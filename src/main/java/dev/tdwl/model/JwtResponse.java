package dev.tdwl.model;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private String id;

    public JwtResponse(String accessToken, String email, String id) {
        this.token = accessToken;
        this.email = email;
        this.id = id;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
