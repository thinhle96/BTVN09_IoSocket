package IoSocketEx2;

import java.util.ArrayList;

public class TcpPacket {
	private static final long serialVersionUID = -658654098253098757L;
	
	private int lengthOfMessage;
	private short cmdCode;
	private short version;
	
	private ArrayList<TLV> tlvs;
	
	public TcpPacket(int code, ArrayList<TLV> tlv) {
		cmdCode = (short) code;
		version = 0;
		this.setTlvs(tlv);
	}
	
	public TcpPacket(int code,TLV tlv) {
		cmdCode = (short) code;
		version = 0;
		this.setTlvs(new ArrayList<>());
	}
	

	public int getLengthOfMessage() {
		return lengthOfMessage;
	}

	public void setLengthOfMessage(int lengthOfMessage) {
		this.lengthOfMessage = lengthOfMessage;
	}

	public short getCmdCode() {
		return cmdCode;
	}

	public void setCmdCode(short cmdCode) {
		this.cmdCode = cmdCode;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public ArrayList<TLV> getTlvs() {
		return tlvs;
	}

	public void setTlvs(ArrayList<TLV> tlvs) {
		this.tlvs = tlvs;
	}

	


}
