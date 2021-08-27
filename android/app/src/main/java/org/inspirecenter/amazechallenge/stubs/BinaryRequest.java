package org.inspirecenter.amazechallenge.stubs;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.protobuf.GeneratedMessageV3;

import java.util.HashMap;
import java.util.Map;

public class BinaryRequest extends Request<byte[]> {

    private final Response.Listener<byte[]> successListener;
    private final GeneratedMessageV3 message;
    private Map<String, String> responseHeaders = new HashMap<>();

    public BinaryRequest(int method, String url, GeneratedMessageV3 message, Response.Listener<byte[]> successListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        setShouldCache(false);
        this.successListener = successListener;
        this.message = message;
    }

    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
        responseHeaders = response.headers;
        return Response.success(response.data, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(byte[] response) {
        successListener.onResponse(response);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return message.toByteArray();
    }

    public GeneratedMessageV3 getMessage() {
        return message;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

}