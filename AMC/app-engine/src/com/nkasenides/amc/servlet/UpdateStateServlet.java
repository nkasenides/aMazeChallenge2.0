/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.servlet;

import com.nkasenides.amc.service.Services;
import com.nkasenides.athlos.exception.ServiceNotFoundException;
import com.nkasenides.athlos.serverless.servlet.AthlosServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class UpdateStateServlet extends AthlosServlet {

    @Override
    protected byte[] callProcessMethod(HttpServletRequest servletRequest, HttpServletResponse servletResponse, DataInputStream inputStream) throws ServiceNotFoundException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        final Object[] additionalParameters = {
              servletRequest.getRemoteAddr(),
        };
        return Services.updateState(buffer.toByteArray(), additionalParameters).toByteArray();
    }

}
