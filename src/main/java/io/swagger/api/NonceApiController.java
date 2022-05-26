package io.swagger.api;

import io.swagger.BCGateway.BCGateway;
import io.swagger.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-26T09:37:19.856Z[GMT]")
@RestController
public class NonceApiController implements NonceApi {

    private static final Logger log = LoggerFactory.getLogger(NonceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public NonceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Response> getAddressNonce(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Account address." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "address", required = true) String address) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            Response res = new Response();
            try {
                int nonce = BCGateway.getNonce(address);
                res.setResponse(String.valueOf(nonce));
                if (nonce > -1){
                    return new ResponseEntity<Response>(res,HttpStatus.OK);
                }
                return new ResponseEntity<Response>(objectMapper.readValue("{\n  \"response\" : \"-1\",\n  \"id\" : \"0\"\n}", Response.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}