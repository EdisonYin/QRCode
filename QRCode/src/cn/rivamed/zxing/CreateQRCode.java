package cn.rivamed.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {
	public static void main(String[] args) {
		
		int width=300;
		int height=300;
		
		String format="png";
		//������������Զ���ת�Ļ�����Ҫ����https://
		String content="https://github.com/hbbliyong/QRCode.git";
		
		HashMap hits=new HashMap();
		hits.put(EncodeHintType.CHARACTER_SET, "utf-8");//����
		//����ȼ�������ȼ�Խ�ߴ洢��ϢԽ��
		hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//�߾�
		hits.put(EncodeHintType.MARGIN, 2);
		
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hits);
			//�������ҳ������������������
			//MatrixToImageWriter.writeToStream(matrix, format, stream);
			Path path=new File("D:/zxingQRCode.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("that is all");
	}
}
