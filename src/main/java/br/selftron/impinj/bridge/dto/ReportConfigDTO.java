package br.selftron.impinj.bridge.dto;

import java.util.ArrayList;
import java.util.List;

import com.impinj.octane.ReportMode;

public class ReportConfigDTO {
	
	private ReportMode mode;
	private boolean includeAntennaPortNumber;
	private boolean includeFirstSeenTime;
	private boolean includeLastSeenTime;
	private boolean includePeakRssi;
	private boolean includeSeenCount;
	private boolean includeFastId;
	private boolean includePhaseAngle;
	private boolean includeDopplerFrequency;
	private boolean includeGPSCoordinates;
	private boolean includePcBits;
	private boolean includeCrc;
	private List<TagReadOpDTO> optimizeReadOps = new ArrayList<>();
	
	public ReportConfigDTO() {
	}

	public ReportMode getMode() {
		return mode;
	}

	public void setMode(ReportMode mode) {
		this.mode = mode;
	}

	public boolean isIncludeAntennaPortNumber() {
		return includeAntennaPortNumber;
	}

	public void setIncludeAntennaPortNumber(boolean includeAntennaPortNumber) {
		this.includeAntennaPortNumber = includeAntennaPortNumber;
	}

	public boolean isIncludeFirstSeenTime() {
		return includeFirstSeenTime;
	}

	public void setIncludeFirstSeenTime(boolean includeFirstSeenTime) {
		this.includeFirstSeenTime = includeFirstSeenTime;
	}

	public boolean isIncludeLastSeenTime() {
		return includeLastSeenTime;
	}

	public void setIncludeLastSeenTime(boolean includeLastSeenTime) {
		this.includeLastSeenTime = includeLastSeenTime;
	}

	public boolean isIncludePeakRssi() {
		return includePeakRssi;
	}

	public void setIncludePeakRssi(boolean includePeakRssi) {
		this.includePeakRssi = includePeakRssi;
	}

	public boolean isIncludeSeenCount() {
		return includeSeenCount;
	}

	public void setIncludeSeenCount(boolean includeSeenCount) {
		this.includeSeenCount = includeSeenCount;
	}

	public boolean isIncludeFastId() {
		return includeFastId;
	}

	public void setIncludeFastId(boolean includeFastId) {
		this.includeFastId = includeFastId;
	}

	public boolean isIncludePhaseAngle() {
		return includePhaseAngle;
	}

	public void setIncludePhaseAngle(boolean includePhaseAngle) {
		this.includePhaseAngle = includePhaseAngle;
	}

	public boolean isIncludeDopplerFrequency() {
		return includeDopplerFrequency;
	}

	public void setIncludeDopplerFrequency(boolean includeDopplerFrequency) {
		this.includeDopplerFrequency = includeDopplerFrequency;
	}

	public boolean isIncludeGPSCoordinates() {
		return includeGPSCoordinates;
	}

	public void setIncludeGPSCoordinates(boolean includeGPSCoordinates) {
		this.includeGPSCoordinates = includeGPSCoordinates;
	}

	public boolean isIncludePcBits() {
		return includePcBits;
	}

	public void setIncludePcBits(boolean includePcBits) {
		this.includePcBits = includePcBits;
	}

	public boolean isIncludeCrc() {
		return includeCrc;
	}

	public void setIncludeCrc(boolean includeCrc) {
		this.includeCrc = includeCrc;
	}

	public List<TagReadOpDTO> getOptimizeReadOps() {
		return optimizeReadOps;
	}

	public void setOptimizeReadOps(List<TagReadOpDTO> optimizeReadOps) {
		this.optimizeReadOps = optimizeReadOps;
	}

}
