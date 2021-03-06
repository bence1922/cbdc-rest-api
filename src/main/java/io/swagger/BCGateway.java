package io.swagger;

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
import org.hyperledger.fabric.gateway.Wallets;
import org.hyperledger.fabric.protos.common.Common;
import org.hyperledger.fabric.sdk.BlockchainInfo;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.TransactionInfo;


public class BCGateway {
    static Gateway.Builder builder;
    public static void init() throws IOException, ContractException {
        // Load an existing wallet holding identities used to access the network.
        Path walletDirectory = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletDirectory);

        // Path to a common connection profile describing the network.
        Path networkConfigFile = Paths.get("crypto-config.json");

        // Configure the gateway connection used to access the network.
        builder = Gateway.createBuilder()
                .identity(wallet, "user@tmit.bme.hu")
                .networkConfig(networkConfigFile);
        System.out.println("BC init done");
    }
    public static String ConnectivityTest(){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo");
            Contract contract = network.getContract("epengo");
            contract.evaluateTransaction("ping");
            System.out.println("ping done");
            return "ping done";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    public static String ApplyForGreenCbdc(String address, String lockedUserAmount, String requestedAmount, String totalPayout, String verifierDocUri){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo");
            Contract contract = network.getContract("epengo");
            Transaction t = contract.createTransaction("applyForGreenCbdc").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(address, lockedUserAmount,requestedAmount,verifierDocUri);
            System.out.println("Apply for green CBDC On Fabric done.");

            t = contract.createTransaction("approveGreenCbdc").setEndorsingPeers(network.getChannel().getPeers());;
            t.submit(address,totalPayout,"60");
            System.out.println("Approve green CBDC On Fabric done.");
            return "successful green CBDC request";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    public static String Transfer(String from, String to, String value,String pocket,String nextNonce, String v, String r, String s){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo");
            Contract contract = network.getContract("epengo");
            
            Transaction t = contract.createTransaction("transferFromPocket").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(from, to,value,pocket,nextNonce, v, r, s);
            System.out.println("Transfer On Fabric done.");
            String transferID = t.getTransactionId();
            System.out.print("generated transfer id: " + transferID);
            return transferID;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    public static String getNonce(String address){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo");
            Contract contract = network.getContract("epengo");
            System.out.println(Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1);
            return String.valueOf(Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1);
        }catch(Exception e){
            System.out.print(e.getMessage());
            return e.getMessage();
        }
        
            
    }
    public static String checkTransfer(String transferID, String from, String to, String value){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("epengo");
            TransactionInfo ti =  network.getChannel().queryTransactionByID(transferID);
            System.out.println("TransactionID: " + ti.getTransactionID() + " ,valid: " + ti.getValidationCode());
            /*FabricProposalResponse.ProposalResponsePayload pl = FabricProposalResponse.ProposalResponsePayload.parseFrom(ti.getProcessedTransaction().getTransactionEnvelope().getPayload());
            char per = 92;
            String[] data = pl.toString().replace(per+"","separate").split("separate");
            int balanceIndex = indexOfIntArray(data, "022transferFromPocket");
            
            String from1 = data[balanceIndex+1].substring(2);
            String to1 = data[balanceIndex+2].substring(2);
            if(from.equals(from1) && to.equals(to1) && transfered(data)>-1 && ti.getValidationCode().toString().equals("VALID")){
                return "VALID";
            }*/
            return ti.getValidationCode() + "";
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return "INVALID";
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
            if (array[i].contains("epengo"))
            {
                String temp = array[i].split("@")[1];
                return temp.substring(0,temp.length()-1);
            }
        }
        return null;
    }
}
