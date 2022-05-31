package io.swagger.BCGateway;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Transaction;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.protos.common.Common;
import org.hyperledger.fabric.protos.peer.FabricProposalResponse;
import org.hyperledger.fabric.sdk.BlockchainInfo;
import org.hyperledger.fabric.sdk.TransactionInfo;


public class BCGateway {
    static Gateway.Builder builder;
    public static void init() throws IOException, ContractException {
        // Load an existing wallet holding identities used to access the network.
        Path walletDirectory = Paths.get("src/wallet");
        Wallet wallet = Wallet.createFileSystemWallet(walletDirectory);

        // Path to a common connection profile describing the network.
        Path networkConfigFile = Paths.get("src/crypto-config.json");

        // Configure the gateway connection used to access the network.
        builder = Gateway.createBuilder()
                .identity(wallet, "Admin@fi.example.com")
                .networkConfig(networkConfigFile);
        System.out.println("BC init done");
    }
    public static boolean ConnectivityTest(){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo-channel");
            Contract contract = network.getContract("cbdc");
            contract.evaluateTransaction("ping");
            System.out.println("ping done");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static String Transfer(String from, String to, String value,String nextNonce, String v, String r, String s){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo-channel");
            Contract contract = network.getContract("cbdc");

            Transaction t = contract.createTransaction("transfer");
            t.submit(from, to,value, nextNonce, v, r, s);
            System.out.println("Transfer On Fabric done.");

            byte[] blockHash;
            BlockchainInfo bci =  network.getChannel().queryBlockchainInfo();
            byte[] curBlockHash = bci.getCurrentBlockHash();
            if (network.getChannel().queryBlockByHash(curBlockHash).getTransactionCount() < 1)
                blockHash = bci.getPreviousBlockHash();
            else
                blockHash = curBlockHash;
            Common.BlockData bd = network.getChannel().queryBlockByHash(blockHash).getBlock().getData();
            char per = 92;
            String[] data = bd.toString().replace(per+"","separate").split("separate");
            String transferID = transferId(data);
            System.out.print("generated transfer id: " + transferID);
            return transferID;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static int getNonce(String address){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo-channel");
            Contract contract = network.getContract("cbdc");
            System.out.println(Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1);
            return Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1;
        }catch(Exception e){
            System.out.print(e.getMessage());
            return -1;
        }
        
            
    }
    public static boolean checkTransfer(String transferID, String from, String to, String value){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo-channel");
            TransactionInfo ti =  network.getChannel().queryTransactionByID(transferID);
            System.out.println("TransactionID: " + ti.getTransactionID() + " ,valid: " + ti.getValidationCode());
            FabricProposalResponse.ProposalResponsePayload pl = FabricProposalResponse.ProposalResponsePayload.parseFrom(ti.getProcessedTransaction().getTransactionEnvelope().getPayload());
            char per = 92;
            String[] data = pl.toString().replace(per+"","separate").split("separate");
            int balanceIndex = indexOfIntArray(data, "btransfer");
            
            String from1 = data[balanceIndex+1].substring(2);
            String to1 = data[balanceIndex+2].substring(2);
            if(from.equals(from1) && to.equals(to1) && transfered(data)>-1 && ti.getValidationCode().toString().equals("VALID")){
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        
    }
    public static int indexOfIntArray(String[] array, String key) {
        for (int i = 0; i < array.length; ++i) {
            if (key.equals(array[i])) 
                return i;
        }
        return -1;
    }
    public static int transfered(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].contains("UnitsTransferred"))
                return Integer.parseInt(array[i].replace("UnitsTransferred",""));
        }
        return -1;
    }
    public static String transferId(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].contains("epengo-channel"))
            {
                String temp = array[i].split("@")[1];
                return temp.substring(0,temp.length()-1);
            }
        }
        return null;
    }
}
