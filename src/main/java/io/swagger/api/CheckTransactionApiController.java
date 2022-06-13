package io.swagger.api;

import io.swagger.BCGateway;
import io.swagger.model.Response;
import io.swagger.model.TransferInformation;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")
@RestController
public class CheckTransactionApiController implements CheckTransactionApi {

    private static final Logger log = LoggerFactory.getLogger(CheckTransactionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CheckTransactionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Response> checkTransaction(@Parameter(in = ParameterIn.DEFAULT, description = "Add a Transfer.", required=true, schema=@Schema()) @Valid @RequestBody TransferInformation body) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            Response res = new Response();
            res.setResponse(BCGateway.checkTransfer(body.getTransactionId(),body.getFrom(),body.getTo(),String.valueOf(body.getAmount())));
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
        return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
    }

}
