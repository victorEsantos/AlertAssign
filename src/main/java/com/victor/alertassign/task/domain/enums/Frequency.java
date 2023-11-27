package com.victor.alertassign.task.domain.enums;

public enum Frequency {

    MINUTELY {
        @Override
        public String getCron() {
            return "0 0/1 * ? * *";
        }
    },
    //5 min in 5 min
    FIVE_MINUTES {
        @Override
        public String getCron() {
            return "0 0/5 * ? * *";
        }
    },
    DAILY {
        @Override
        public String getCron() {
            return "0 0 0 * * ?";
        }
    },
    WEEKLY {
        @Override
        public String getCron() {
            return "0 0 0 ? * MON";
        }
    },
    MONTHLY {
        @Override
        public String getCron() {
            return "0 0 0 1 * ?";
        }
    };

    public abstract String getCron();
}
