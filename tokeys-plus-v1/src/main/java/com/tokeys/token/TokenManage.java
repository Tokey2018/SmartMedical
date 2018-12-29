package com.tokeys.token;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.*;
import org.apache.commons.collections.map.HashedMap;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum TokenManage {
    MANAGE
    ;

    TokenManage() {
    }

    /**
     * 获取加密key
     * @return
     */
    public  SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(JWTConstant.JWT_SECERT.getVlaue());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     *签发JWT
     * @param userJson
     * @return
     */
    public  String createSimpleJWT(String userJson) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(JWTConstant.JWT_ID.getVlaue())
                .setSubject(userJson)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (JWTConstant.EXPIRATION_TIME.getLg() >= 0) {
            long expMillis = nowMillis + JWTConstant.EXPIRATION_TIME.getLg();
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }
    /**
     * 签发JWT
     * @param jwtId
     * @param subject
     * @param expirationTime
     * @return
     * @throws Exception
     */
    public String createJWT(SecretKey secretKey,String jwtId, Map subject, long expirationTime) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(jwtId)
                .setClaims(subject)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (expirationTime >= 0) {
            long expMillis = nowMillis + expirationTime;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }


    /**
     * 签发JWT
     * @param userMap
     * @return
     */
    public  String createJWT(Map userMap) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(JWTConstant.JWT_ID.getVlaue())
                .setClaims(userMap)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (JWTConstant.EXPIRATION_TIME.getLg() >= 0) {
            long expMillis = nowMillis + JWTConstant.EXPIRATION_TIME.getLg();
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }
    /**
     *
     * 解析JWT字符串
     * @param jwtsStr
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwtsStr) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtsStr)
                .getBody();
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public  CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(JWTConstant.JWT_ERRCODE_EXPIRE.getLg());
            checkResult.setSuccess(false);
        } catch (MalformedJwtException e){
            checkResult.setErrCode(JWTConstant.JWT_ERRCODE_DATA.getLg());
            checkResult.setSuccess(false);
        }
        catch (SignatureException e) {
            checkResult.setErrCode(JWTConstant.JWT_ERRCODE_FAIL.getLg());
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(JWTConstant.JWT_ERRCODE_FAIL.getLg()
            );
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public  Map validate(String jwtStr) {
        Map map = new HashMap();
        try {
            map = Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(jwtStr).getBody();
        } catch (ExpiredJwtException e) {
            //Token过期
            map.put(JWTConstant.JWT_ERRCODE_CODE.getVlaue(), JWTConstant.JWT_ERRCODE_EXPIRE.getLg());
            map.put(JWTConstant.JWT_ERRCODE_MSG.getVlaue(),"Token Expired ");
        } catch (SignatureException e) {
            //验证不通过
            map.put(JWTConstant.JWT_ERRCODE_CODE.getVlaue(), JWTConstant.JWT_ERRCODE_FAIL.getLg());
            map.put(JWTConstant.JWT_ERRCODE_MSG.getVlaue(),"Token  Verification failed");
        } catch (MalformedJwtException e) {
            //数据格式不对
            map.put(JWTConstant.JWT_ERRCODE_CODE.getVlaue(), JWTConstant.JWT_ERRCODE_DATA.getLg());
            map.put(JWTConstant.JWT_ERRCODE_MSG.getVlaue(),"Token Date erro");
        } catch (IllegalArgumentException e) {
            map.put(JWTConstant.JWT_ERRCODE_CODE.getVlaue(), JWTConstant.JWT_ERRCODE_FAIL.getLg());
            map.put(JWTConstant.JWT_ERRCODE_MSG.getVlaue(),"Token Verification failed");
        }
        return map;
    }





    /**
     *
     *测试验证 validateJWT()
     * @param args
     */
   /*
    public static void main(String[] args) {
        String jwt = TokenManage.MANAGE.createSimpleJWT("894642uy9t8y452gh5");
        System.out.println("jwt==" + jwt);
        boolean b = MANAGE.validateJWT(jwt).isSuccess();

        String st = TokenManage.MANAGE.validateJWT(jwt).getClaims().toString();

        System.out.println(TokenManage.MANAGE.validateJWT(jwt).getErrCode() + "b=" + b + "st==" + st);
        // System.out.println(TokenManage.MANAGE.validateJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMDE4MTIyOGEiLCJzdWIiOiI4OTQ2NDJ1eTl0OHk0NTJnaDUiLCJpYXQiOjE1NDU5OTI1NTgsImV4cCI6MTU0NTk5MjU2M30.vr0OONujo96aDusHIj3llyFq8PrgkJaCfh9OgwYOg0k" ).getErrCode());

    }
   */



    /**
     *
     *测试验证 validate()
     * @param args
     */

    public static void main(String[] args) {
        Map<String, Object> map = new HashedMap();
        map.put("uid", 1);
        map.put("name", "guogongjun");
        map.put("phone", "13330352893");

        //String jwt = TokenManage.MANAGE.createJWT(map);
        // System.out.println("jwt==" + jwt);

        // System.out.println(TokenManage.MANAGE.validate(jwt).toString());

        System.out.println(TokenManage.MANAGE.validate("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjEzMzMwMzUyODkzIiwiZXhwIjoxNTQ2MDA1MzQ1LCJpYXQiOjE1NDYwMDE3NDUsInVpZCI6MSwibmFtZSI6Imd1b2dvbmdqdW4ifQ.6e6v6Mo9iBWnwAX5BWo1iTAt-C5uJ1mZL4vz7QSl-gY").toString());
        //System.out.println(Jwts.parser().setSigningKey(TokenManage.MANAGE.generalKey()).parseClaimsJws(jwt).getBody());
    }


}
