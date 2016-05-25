package fx.service;

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
    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * list of name-value pairs of request headers
     */
    private enum RequestType {
        GET,
        POST
    }

    private RequestType rtype;

    public HttpBuilder(String uri) {
        this.uri = uri;
    }

    public HttpBuilder get() {
        rtype = RequestType.GET;
        return this;
    }

    public HttpBuilder post() {
        rtype = RequestType.POST;
        return this;
    }

    public HttpBuilder header(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public HttpBuilder parameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public Response execute() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String url = uri + buildParameterString();
        switch (rtype) {
            case GET:
                request = new HttpGet(url);
                break;
            case POST:
                request = new HttpPost(url);
                break;
        }
        for (String name : headers.keySet()) {
            request.addHeader(name, headers.get(name));
        }

        Response response = new Response();
        try {
            HttpResponse resp = httpClient.execute(request);
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
        } catch (
                IOException e
                )
        {
            e.printStackTrace();
        }
        return response;
    }

    private String buildParameterString() {
        StringBuilder result = new StringBuilder();
        if (parameters.size() == 0) return "";
        else {
            for (String name : parameters.keySet()) { // HashMap("name", "val") --> "name=val&"
                result.append(name).append("=").append(parameters.get(name)).append('&');
            }
            result.insert(0, '?'); // insert first symbol '?'
            result.deleteCharAt(result.length() - 1); // delete last symbol '&'
        }
        return result.toString();
    }
}
