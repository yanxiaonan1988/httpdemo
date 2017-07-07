package http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanxiaonan on 17/7/7.
 */
public class HttpBase {
    private String method;
    private String version;
    private String protocol;
    private String path;
    private String status;
    private String body;
    private Map<String, String> headers;

    public HttpBase() {
        headers = new HashMap<String, String>();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void addHeader(String key, String value){
        this.headers.put(key, value);
    }

    public String getHeader(String key){
        return this.headers.get(key);
    }

    public Map<String, String> getHeaders() { return this.headers; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
