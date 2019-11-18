package sample.Enums;

public enum AvailabilityOfCarClass {
    Есть{
        @Override
                public String toString() {return "Есть";}
    },
    Нету{
        @Override
                public String toString() {return "Нету"; }
    }
}
