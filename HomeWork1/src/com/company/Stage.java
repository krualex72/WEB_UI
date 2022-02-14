package com.company;

public class Stage {
    private String exName; // название испытания
    private float phyCondLimit; // требуемый лимит физического состояния (%)

    Stage (String exName, float phyCondLimit) {
        this.exName = exName;
        this.phyCondLimit = phyCondLimit;
    }
    public String getExName() {
        return exName;
    }
    public float getPhyCondLimit() {
        return phyCondLimit;
    }
}
