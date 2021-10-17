package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;

    private final Set<HeavenlyBody> satellites;

    enum BodyType{
        PLANET, DWARF_PLANET, MOON;

    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody item){
        if (this.key.bodyType.equals(BodyType.PLANET) && !item.key.bodyType.equals(BodyType.MOON)){
            System.out.println("Planet's satellite must be a moon");
            return false;
        }
        return satellites.add(item);

    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyType bodyType){
        return new Key(name, bodyType);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            Key objKey = ((HeavenlyBody) obj).getKey();
//            BodyType objBodyType= ((HeavenlyBody) obj).bodyType;
//            return (this.key.equals(objKey) && this.key.bodyType.equals(objBodyType));
            return (this.key.equals(objKey));
        }
        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return key.toString();
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        private Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public String toString() {
            return "Name: " + this.name + "Body Type: " + bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return name.equals(key.name) && bodyType == key.bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 3;
        }
    }
}
