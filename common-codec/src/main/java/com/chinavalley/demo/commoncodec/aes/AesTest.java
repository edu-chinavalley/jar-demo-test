package com.chinavalley.demo.commoncodec.aes;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author: polfdark
 */
public class AesTest {

    public static void main(String ...args) throws UnsupportedEncodingException {
        byte[] aesKey = AesKit.getRawKey(System.currentTimeMillis(),128);
        System.out.println(new String(aesKey,"utf-8"));
        String key = HexKit.bytesToHexStr(aesKey);
        System.out.println(key);
        String clearText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
//        System.out.println(HexKit.bytesToHexStr(AesKit.encrypt(clearText.getBytes("utf-8"),HexKit.hexStrToBytes(key))));
        KeyPair kp = RsaKit.generateRSAKeyPair();
        PrivateKey priKey = RsaKit.loadPriKey("30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100aeec305214bfe43eb65236d0060c315e2a8fdd105a3cb51887e14459d471a1e725e06df076de0986d6e9ec86a65f68cf101ba8872ae2dd21fdb494130eeebe9549bc15b9f7b0fbb8044f8729408e1ed01c9f345b05a3b648f137ea212de145575556b6a24b7d6b802c96baa31f4d4c19a08e86d251b904b7ee51d71d197408bd02030100010281805d8788a6bad587d34865594d8d8e436f584ea823303cb9902e4772e69d434d106d1e3d6a9004550fb6264a040d3d82ab04afe542b0d9b0e795e25232868f7d732ed031ed82691f7823a7cf9bf7bae8546b2b2a0f0ae8df73280ee84555d12b66ffb4de13c85de0618ee6cdfa987670b35e571e3c193f1e0f8c6a1d431801b5f9024100e0a04a568a56ac53cbfeb9639b9d49e3cba50e7d4078215375725fc18dcd81c01102fd134f176068c0630c3e646b38bd586c3f5b037f7c899c592c913e545a6f024100c75ab446a05736a5518c9cb5b55f2c81b049b9ab87c6788a4ced9dbef9ee70434dc44a33fc325095f1e3e605a71b57a763b74afe368bc497bc4127674677159302410092712dc5b9aec3ee65a20d6f18f6b4436472993da3182e71e0b1ce27bbb0ed1430830846dc5b5b292fb3e33991f22d2d94460e0fe1f9ed5131b319511f9792d502402df4d702410c59e89a7813d83fcb84f310b4ae3cc0bc1c25a5be51532942b25691a2e288416747f48922c4702129c8772a21a3041f86f0f719cadb4e8f8bfc4902403568aa1e0fe89ae36b574ba41fed5769ac8cfe4e6071e360d6ee92a3751fd4b17c3d6b0bac4cd2fd5a63b7e0c3448457fe5802b8ad816dc320e3fa152aa36190");
        PublicKey pubKey = RsaKit.loadPubKey("30819f300d06092a864886f70d010101050003818d0030818902818100aeec305214bfe43eb65236d0060c315e2a8fdd105a3cb51887e14459d471a1e725e06df076de0986d6e9ec86a65f68cf101ba8872ae2dd21fdb494130eeebe9549bc15b9f7b0fbb8044f8729408e1ed01c9f345b05a3b648f137ea212de145575556b6a24b7d6b802c96baa31f4d4c19a08e86d251b904b7ee51d71d197408bd0203010001");
//        System.out.println(HexKit.bytesToHexStr(priKey.getEncoded()));
//        System.out.println(HexKit.bytesToHexStr(pubKey.getEncoded()));
        System.out.println(RsaKit.sign(clearText,HexKit.bytesToHexStr(priKey.getEncoded())));
        System.out.println(HexKit.bytesToHexStr(RsaKit.encrypt(clearText.getBytes("utf-8"),pubKey)));



        //808b13bbc6fa7b4cde23a833e61942afe065cd9349b8e67cf6e39363f9459d0270d4325c1ef85084c70bbaeab39415127d6a280487a5422a12575fef21196c18bcef4d83050a708ffa0477c64eb84f884dee7c65a8fb0212383b7e10c2d9570c3a07cc019031f2e0453a3d59ebfa3716b979d9b4edc56c1f53f8884653311ab1
        //09DE51104793AA34F1B9910CFEF988E9875C914F01F20E2CB7F9180F97BD5495ED8B2056A330F2E2BFF022221C3FA466E7FF23CAF5C34B93AF99C7F1FDC95E74B7714C6B5EC8636B958E96AB10DF118366C5DBA2F8BDBA2160BAD07CE87AB4C55F390A5F38430AF9E8BED1DD4B1AF6D71C544638ED3CAEF14CFC8890F539A9D4
    }
}
