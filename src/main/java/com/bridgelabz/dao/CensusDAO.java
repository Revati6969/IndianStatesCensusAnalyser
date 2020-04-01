package com.bridgelabz.dao;
import com.bridgelabz.dto.CSVStatesCensus;
import com.bridgelabz.dto.CSVStatesPojoClass;
import com.bridgelabz.dto.CSVUSCensus;
import com.bridgelabz.service.CensusAnalyser;
import java.util.Comparator;

public class CensusDAO {
    public String StateID;
    public String State;
    public long Population;
    public long AreaInSqKm;
    public long DensityPerSqkm;
    public String StateCode;
    public int TIN;
    public int SrNo;

    public CensusDAO(CSVStatesCensus csvStatesCensus) {
        this.State = CSVStatesCensus.state;
        this.Population = csvStatesCensus.Population;
        this.AreaInSqKm = csvStatesCensus.AreaInSqKm;
        this.DensityPerSqkm = csvStatesCensus.DensityPerSqkm;
    }

    public CensusDAO(CSVStatesPojoClass csvStatesPojoClass) {
        this.State = csvStatesPojoClass.StateName;
        this.SrNo = csvStatesPojoClass.SrNo;
        this.TIN = csvStatesPojoClass.TIN;
        this.StateCode = csvStatesPojoClass.StateCode;
    }

    public CensusDAO(CSVUSCensus csvusCensus) {
        this.StateID = csvusCensus.StateID;
        this.State = csvusCensus.State;
        this.Population = csvusCensus.Population;
        this.AreaInSqKm = csvusCensus.Area;
        this.DensityPerSqkm = csvusCensus.PopulationDensity;
    }

    public static Comparator<CensusDAO> getSortComparator(CensusAnalyser.SortingMode mode) {
        if (mode.equals(CensusAnalyser.SortingMode.STATE))
            return Comparator.comparing(census -> census.State);
        if (mode.equals(CensusAnalyser.SortingMode.POPULATION))
            return Comparator.comparing(CensusDAO::getPopulation).reversed();
        if (mode.equals(CensusAnalyser.SortingMode.AREA))
            return Comparator.comparing(CensusDAO::getAreaInSqKm).reversed();
        if (mode.equals(CensusAnalyser.SortingMode.DENSITY))
            return Comparator.comparing(CensusDAO::getDensityPerSqkm).reversed();
        return null;
    }

    public long getPopulation() {
        return Population;
    }

    public long getAreaInSqKm() {
        return AreaInSqKm;
    }

    public long getDensityPerSqkm() {
        return DensityPerSqkm;
    }

    public Object getCensusDTO(CensusAnalyser.Country country) {
        if (country.equals(CensusAnalyser.Country.INDIA))
            return new CSVStatesCensus(State, Population, AreaInSqKm, DensityPerSqkm);
        if (country.equals(CensusAnalyser.Country.US))
            return new CSVUSCensus(StateCode, State, Population, AreaInSqKm, DensityPerSqkm);
        return null;
    }
}
