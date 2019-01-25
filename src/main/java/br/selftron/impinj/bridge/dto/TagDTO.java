package br.selftron.impinj.bridge.dto;

import java.util.ArrayList;
import java.util.List;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReadOpResult;

public class TagDTO {
	
	private TagDataDto epc;
	private short antennaPortNumber;
	private double channelInMhz;
	private long firstSeenTime;
	private long lastSeenTime;
	private double peakRssiInDbm;
	private short tagSeenCount;
	private TagDataDto tid;
	private double rfDopplerFrequency;
	private double phaseAngleRadians;
	private short crc;
	private short pcBits;
	private GpsCoordinatesDTO gpsCoordinates;
	private TagModelDetailsDTO modelDetails;
	private List<TagReadOpResultDTO> readOperationResult = new ArrayList<>();
	private boolean antennaPortNumberPresent;
	private boolean channelInMhzPresent;
	private boolean firstSeenTimePresent;
	private boolean lastSeenTimePresent;
	private boolean fastIdPresent;
	private boolean rfPhaseAnglePresent;
	private boolean seenCountPresent;
	private boolean crcPresent;
	private boolean pcBitsPresent;
	private boolean rfDoppleFrequencyPresent;
	private boolean gpsCoordinatesPresent;
	
	private ReaderDTO reader;
	
	public TagDTO() {
	}
	
	public TagDTO(Tag tag) {
		epc = new TagDataDto(tag.getEpc());
		antennaPortNumber = tag.getAntennaPortNumber();
		channelInMhz = tag.getChannelInMhz();
		if (tag.isFirstSeenTimePresent()) {
			firstSeenTime = tag.getFirstSeenTime().getLocalDateTime().getTime();
			firstSeenTimePresent = true;
		}
		if (tag.isLastSeenTimePresent()) {
			lastSeenTime = tag.getLastSeenTime().getLocalDateTime().getTime();
			lastSeenTimePresent = true;
		}
		peakRssiInDbm = tag.getPeakRssiInDbm();
		tagSeenCount = tag.getTagSeenCount();
		tid = new TagDataDto(tag.getTid());
		rfDopplerFrequency = tag.getRfDopplerFrequency();
		phaseAngleRadians = tag.getPhaseAngleInRadians();
		crc = tag.getCrc();
		pcBits = tag.getPcBits();
		gpsCoordinates = new GpsCoordinatesDTO(tag.getGpsCoodinates());
		modelDetails = new TagModelDetailsDTO(tag.getModelDetails());
		
		for (TagReadOpResult result : tag.getReadOperationResults()) {
			readOperationResult.add(new TagReadOpResultDTO(result));
		}
		
		antennaPortNumberPresent = tag.isAntennaPortNumberPresent();
		channelInMhzPresent = tag.isChannelInMhzPresent();
		//firstSeenTimePresent = tag.isFirstSeenTimePresent();
		//lastSeenTimePresent = tag.isLastSeenTimePresent();
		fastIdPresent = tag.isFastIdPresent();
		rfPhaseAnglePresent = tag.isRfPhaseAnglePresent();
		seenCountPresent = tag.isSeenCountPresent();
		crcPresent = tag.isCrcPresent();
		pcBitsPresent = tag.isPcBitsPresent();
		rfDoppleFrequencyPresent = tag.isRfDopplerFrequencyPresent();
		gpsCoordinatesPresent = tag.isGpsCoordinatesPresent();
		
		
	}
	
	public TagDTO(ImpinjReader reader, Tag tag) {
		this(tag);
		if (reader != null) {
			this.reader = new ReaderDTO(reader);
		}
	}

	public TagDataDto getEpc() {
		return epc;
	}

	public void setEpc(TagDataDto epc) {
		this.epc = epc;
	}

	public short getAntennaPortNumber() {
		return antennaPortNumber;
	}

	public void setAntennaPortNumber(short antennaPortNumber) {
		this.antennaPortNumber = antennaPortNumber;
	}

	public double getChannelInMhz() {
		return channelInMhz;
	}

	public void setChannelInMhz(double channelInMhz) {
		this.channelInMhz = channelInMhz;
	}

	public long getFirstSeenTime() {
		return firstSeenTime;
	}

	public void setFirstSeenTime(long firstSeenTime) {
		this.firstSeenTime = firstSeenTime;
	}

	public long getLastSeenTime() {
		return lastSeenTime;
	}

	public void setLastSeenTime(long lastSeenTime) {
		this.lastSeenTime = lastSeenTime;
	}

	public double getPeakRssiInDbm() {
		return peakRssiInDbm;
	}

	public void setPeakRssiInDbm(double peakRssiInDbm) {
		this.peakRssiInDbm = peakRssiInDbm;
	}

	public short getTagSeenCount() {
		return tagSeenCount;
	}

	public void setTagSeenCount(short tagSeenCount) {
		this.tagSeenCount = tagSeenCount;
	}

	public TagDataDto getTid() {
		return tid;
	}

	public void setTid(TagDataDto tid) {
		this.tid = tid;
	}

	public double getRfDopplerFrequency() {
		return rfDopplerFrequency;
	}

	public void setRfDopplerFrequency(double rfDopplerFrequency) {
		this.rfDopplerFrequency = rfDopplerFrequency;
	}

	public double getPhaseAngleRadians() {
		return phaseAngleRadians;
	}

	public void setPhaseAngleRadians(double phaseAngleRadians) {
		this.phaseAngleRadians = phaseAngleRadians;
	}

	public short getCrc() {
		return crc;
	}

	public void setCrc(short crc) {
		this.crc = crc;
	}

	public short getPcBits() {
		return pcBits;
	}

	public void setPcBits(short pcBits) {
		this.pcBits = pcBits;
	}

	public GpsCoordinatesDTO getGpsCoordinates() {
		return gpsCoordinates;
	}

	public void setGpsCoordinates(GpsCoordinatesDTO gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}

	public TagModelDetailsDTO getModelDetails() {
		return modelDetails;
	}

	public void setModelDetails(TagModelDetailsDTO modelDetails) {
		this.modelDetails = modelDetails;
	}

	public List<TagReadOpResultDTO> getReadOperationResult() {
		return readOperationResult;
	}

	public void setReadOperationResult(List<TagReadOpResultDTO> readOperationResult) {
		this.readOperationResult = readOperationResult;
	}

	public boolean isAntennaPortNumberPresent() {
		return antennaPortNumberPresent;
	}

	public void setAntennaPortNumberPresent(boolean antennaPortNumberPresent) {
		this.antennaPortNumberPresent = antennaPortNumberPresent;
	}

	public boolean isChannelInMhzPresent() {
		return channelInMhzPresent;
	}

	public void setChannelInMhzPresent(boolean channelInMhzPresent) {
		this.channelInMhzPresent = channelInMhzPresent;
	}

	public boolean isFirstSeenTimePresent() {
		return firstSeenTimePresent;
	}

	public void setFirstSeenTimePresent(boolean firstSeenTimePresent) {
		this.firstSeenTimePresent = firstSeenTimePresent;
	}

	public boolean isLastSeenTimePresent() {
		return lastSeenTimePresent;
	}

	public void setLastSeenTimePresent(boolean lastSeenTimePresent) {
		this.lastSeenTimePresent = lastSeenTimePresent;
	}

	public boolean isFastIdPresent() {
		return fastIdPresent;
	}

	public void setFastIdPresent(boolean fastIdPresent) {
		this.fastIdPresent = fastIdPresent;
	}

	public boolean isRfPhaseAnglePresent() {
		return rfPhaseAnglePresent;
	}

	public void setRfPhaseAnglePresent(boolean rfPhaseAnglePresent) {
		this.rfPhaseAnglePresent = rfPhaseAnglePresent;
	}

	public boolean isSeenCountPresent() {
		return seenCountPresent;
	}

	public void setSeenCountPresent(boolean seenCountPresent) {
		this.seenCountPresent = seenCountPresent;
	}

	public boolean isCrcPresent() {
		return crcPresent;
	}

	public void setCrcPresent(boolean crcPresent) {
		this.crcPresent = crcPresent;
	}

	public boolean isPcBitsPresent() {
		return pcBitsPresent;
	}

	public void setPcBitsPresent(boolean pcBitsPresent) {
		this.pcBitsPresent = pcBitsPresent;
	}

	public boolean isRfDoppleFrequencyPresent() {
		return rfDoppleFrequencyPresent;
	}

	public void setRfDoppleFrequencyPresent(boolean rfDoppleFrequencyPresent) {
		this.rfDoppleFrequencyPresent = rfDoppleFrequencyPresent;
	}

	public boolean isGpsCoordinatesPresent() {
		return gpsCoordinatesPresent;
	}

	public void setGpsCoordinatesPresent(boolean gpsCoordinatesPresent) {
		this.gpsCoordinatesPresent = gpsCoordinatesPresent;
	}

	public ReaderDTO getReader() {
		return reader;
	}

	public void setReader(ReaderDTO reader) {
		this.reader = reader;
	}

}
