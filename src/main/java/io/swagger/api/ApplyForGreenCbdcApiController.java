package io.swagger.api;

import io.swagger.BCGateway;
import io.swagger.model.GreenCBDCRequestInformation;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")
@RestController
public class ApplyForGreenCbdcApiController implements ApplyForGreenCbdcApi {

    private static final Logger log = LoggerFactory.getLogger(ApplyForGreenCbdcApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApplyForGreenCbdcApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Response> applyForGreenCbdc(@Parameter(in = ParameterIn.DEFAULT, description = "Add informations for request.", required=true, schema=@Schema()) @Valid @RequestBody GreenCBDCRequestInformation body) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            Response res = new Response();
            res.setResponse(BCGateway.ApplyForGreenCbdc(body.getAddress(),String.valueOf(body.getLockedUserAmount()),
                String.valueOf(body.getRequestedAmount()), String.valueOf(body.getVerifierDocUri())));
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
        return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
    }

}
