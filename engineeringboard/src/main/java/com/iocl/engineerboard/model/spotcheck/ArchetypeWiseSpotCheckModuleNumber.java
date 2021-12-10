package com.iocl.dhruva2api.model.spotcheck;

import java.util.ArrayList;

public class ArchetypeWiseSpotCheckModuleNumber {

	private int archetype;
	private ArrayList<Integer> modules;

	public ArchetypeWiseSpotCheckModuleNumber() {

	}

	public ArchetypeWiseSpotCheckModuleNumber(int archetype) {
		super();
		this.archetype = archetype;
		this.modules = new ArrayList<>();
	}

	/**
	 * @return the archetype
	 */
	public int getArchetype() {
		return archetype;
	}

	/**
	 * @param archetype the archetype to set
	 */
	public void setArchetype(int archetype) {
		this.archetype = archetype;
	}

	/**
	 * @return the modules
	 */
	public ArrayList<Integer> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(ArrayList<Integer> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "ArchetypeWiseSpotCheckModuleNumber [archetype=" + archetype + ", modules=" + modules + "]";
	}

}
