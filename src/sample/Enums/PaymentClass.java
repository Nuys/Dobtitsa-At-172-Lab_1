package sample.Enums;

public enum PaymentClass {
    Оплачено{
        @Override
                public String toString() {return "Оплачено";}
    },
    Неоплачено{
        @Override
                public String toString() {return "Неоплачено";}
    }
}
