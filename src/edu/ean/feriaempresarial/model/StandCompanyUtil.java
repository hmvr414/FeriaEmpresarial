package edu.ean.feriaempresarial.model;

import java.util.Optional;

public class StandCompanyUtil {
    public static Optional<Stand> findStandForCompany(Company company, EntityRegister<StandOccupancy> standOccupancyRegister) {
        Optional<StandOccupancy> standOccupancy = standOccupancyRegister.getEntities().stream()
            .filter(stand -> stand.getCompany().equals(company))
            .findFirst();

        if (standOccupancy.isPresent()) {
            return Optional.of(standOccupancy.get().getStand());
        } else {
            return Optional.empty();
        }
    }

    public static Optional<Company> findCompanyForStand(Stand stand, EntityRegister<StandOccupancy> standOccupancyRegister) {
        for (StandOccupancy occupancy : standOccupancyRegister.getEntities()) {
            if (occupancy.getStand().equals(stand)) {
                return Optional.of(occupancy.getCompany());
            }
        }

        return Optional.empty();
    }
}
