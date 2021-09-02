/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.servlet.admin;

import org.inspirecenter.amazechallenge.model.AdminKey;
import org.inspirecenter.amazechallenge.persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeAdminKeyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String adminKey = req.getParameter("adminKey");
        final String newAdminKey = req.getParameter("newAdminKey");

        if (newAdminKey.equals(adminKey)) {
            resp.getWriter().write("Error: The old and new admin keys cannot be the same");
            return;
        }

        if (newAdminKey.length() < 6) {
            resp.getWriter().write("Error: Invalid new admin key. Admin keys must contain 6 characters or more");
            return;
        }

        final AdminKey adminKeyServer = DBManager.adminKey.get();

        if (adminKeyServer == null) {
            resp.getWriter().write("Error: No admin key on server");
            return;
        }

        if (!adminKeyServer.getId().equals(adminKey)) {
            resp.getWriter().write("Error: Invalid admin key");
            return;
        }

        adminKeyServer.setId(newAdminKey);
        DBManager.adminKey.update(adminKeyServer);

        resp.getWriter().write("OK");

    }
}