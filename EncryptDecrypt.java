package odev;

public interface EncryptDecrypt {
	public void encrypt(String inputFileName, String key);
	public void decrypt(String inputFileName, String key, String outputFileName);
}
