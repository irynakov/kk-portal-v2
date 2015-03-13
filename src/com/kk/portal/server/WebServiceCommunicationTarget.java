package com.kk.portal.server;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kk.portal.shared.domain.comm.req.LoginReq;
import com.kk.portal.shared.domain.comm.resp.LoginResp;
import com.kk.portal.shared.domain.comm.resp.LoginRespErr;

@Path("comm")
@Produces(MediaType.APPLICATION_JSON)
public class WebServiceCommunicationTarget {

	@POST
	@Path("/Login")
	public LoginResp Login(LoginReq req) {

		LoginResp resp = new LoginResp();

		if ("1".equals(req.getPassword())) {
			resp.setUsername(req.getUsername());
			resp.setLoggedin(false);
		} else {
			LoginRespErr error = new LoginRespErr();
			error.setErrorText("Incorrect username/password.");
			resp.setError(error);
		}

		return resp;
	}
}
