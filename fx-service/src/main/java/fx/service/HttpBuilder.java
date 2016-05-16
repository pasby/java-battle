package fx.service;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class used for build http-request and receiving a http-response
 */
public class HttpBuilder {
    private HttpUriRequest request;
    private String uri;
    /**
     * uri of internet-resource, (for example http://bash.im)
     */
    private Map<String, String> parameters = new HashMap<String, String>();
    /**
     * list of name-value pairs of request parameters
     */
    private HttpClient httpClient = HttpClientBuilder.create().build();

    public HttpBuilder(String uri) {
        this.uri = uri;
    }

    public HttpBuilder get() {
        request = new HttpGet(uri + buildParameterString());
        return this;
    }

    public HttpBuilder post() {
        request = new HttpPost(uri + buildParameterString());
        return this;
    }

    public HttpBuilder header(String name, String value) {
        request.addHeader(name, value);
        return this;
    }

    public HttpBuilder header(Header header) {
        request.addHeader(header);
        return this;
    }

    public HttpBuilder parameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public Response execute() {
        Response response = new Response();
        HttpResponse resp = null;
        try {
            resp = httpClient.execute(request);
            response.setCode(resp.getStatusLine().getStatusCode());
            response.setMessage(resp.getStatusLine().getReasonPhrase());
            HttpEntity entity = resp.getEntity();
            if (entity != null) {
                InputStream stream = entity.getContent();
                String line;
                StringBuilder body = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));

                while ((line = br.readLine()) != null) {
                    body.append(line);
                }
                response.setBody(body.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String buildParameterString() {
        StringBuilder result = new StringBuilder();
        if (parameters.size() == 0) return "";
        else {
            for (Object name : parameters.keySet()) { // HashMap("name", "val") --> "name=val&"
                result.append((String) name).append("=").append(parameters.get(name)).append('&');
            }
            result.insert(0, '?'); // insert first symbol '?'
            result.deleteCharAt(result.length() - 1); // delete last symbol '&'
        }
        return result.toString();
    }
}
