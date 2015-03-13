package com.kk.portal.client.app.comm;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.google.inject.Singleton;
import com.kk.portal.shared.domain.comm.req.LoginReq;
import com.kk.portal.shared.domain.comm.resp.LoginResp;

@Singleton
@Path("/api/comm")
public interface WebServiceCommunicationInterface extends RestService {

	@POST
	@Path("/Login")
	public void login(LoginReq login, MethodCallback<LoginResp> callback);
}