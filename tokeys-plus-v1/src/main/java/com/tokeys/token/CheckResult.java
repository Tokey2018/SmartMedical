package com.tokeys.token;

import io.jsonwebtoken.Claims;

/**
 * 验证结果模型
 * @author XY
 *
 */
public class CheckResult {

	private long errCode;
	
	private boolean success;
	
	private Claims claims;

	public long getErrCode() {
		return errCode;
	}

	public void setErrCode(long errCode) {
		this.errCode = errCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	
}
