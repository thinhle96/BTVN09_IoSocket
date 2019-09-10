package IoSocketEx2;

public class TLV {
	private short tag;
	private short length;
	private String value;
	
	public TLV(short tag,String value) {
		this.tag = tag;
		this.length = (short) value.getBytes().length;
		this.value = value;
	}

	public short getTag() {
		return tag;
	}

	public short getLength() {
		return length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
