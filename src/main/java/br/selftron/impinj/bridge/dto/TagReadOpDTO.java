package br.selftron.impinj.bridge.dto;

import com.impinj.octane.MemoryBank;
import com.impinj.octane.TagOp;

public class TagReadOpDTO  extends TagOp {
	
	private TagDataDto _accessPassword;
	private MemoryBank memoryBank;
	private short wordPointer;
	private short wordCount;
	
	public TagReadOpDTO() {
	}

	public TagDataDto get_accessPassword() {
		return _accessPassword;
	}

	public void set_accessPassword(TagDataDto _accessPassword) {
		this._accessPassword = _accessPassword;
	}

	public MemoryBank getMemoryBank() {
		return memoryBank;
	}

	public void setMemoryBank(MemoryBank memoryBank) {
		this.memoryBank = memoryBank;
	}

	public short getWordPointer() {
		return wordPointer;
	}

	public void setWordPointer(short wordPointer) {
		this.wordPointer = wordPointer;
	}

	public short getWordCount() {
		return wordCount;
	}

	public void setWordCount(short wordCount) {
		this.wordCount = wordCount;
	}

}
