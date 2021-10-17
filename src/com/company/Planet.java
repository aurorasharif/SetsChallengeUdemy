package com.company;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody item) {
        if (item.getKey().getBodyType().equals(BodyType.MOON)) {
            return super.addSatellite(item);
        }
        return false;
    }
}
