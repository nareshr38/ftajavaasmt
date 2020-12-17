package com.fta.javaasmt.predicates;

public class Response {
    private String responseBody;
    private ResponseStatusCode responseStatusCode;
    private ResponseType responseType;

    public Response(String responseBody, ResponseStatusCode responseStatusCode, ResponseType responseType) {
        this.responseBody = responseBody;
        this.responseStatusCode = responseStatusCode;
        this.responseType = responseType;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public ResponseStatusCode getResponseStatusCode() {
        return responseStatusCode;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

}
