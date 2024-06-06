package application;



public class Main {
    public static void main(String[] args) {
        Aggregate aggregate = new Aggregate();

        // Simulação de eventos
        People event1 = new People("BIRTH", "People wan born as men");
        People event2 = new People("CHANGED", "People changed to woman");
        People event3 = new People("DIED", "People was died in the war because in his (or her) country have gender iguality and he (or she) went to war");

        // Aplicação dos eventos
        aggregate.applyEvent(event1);
        System.out.println(aggregate.getCurrentState() + "\n");

        aggregate.applyEvent(event2);
        System.out.println(aggregate.getCurrentState() + "\n");
        
        aggregate.applyEvent(event3);
        System.out.println(aggregate.getCurrentState() + "\n");

        // Obtendo o estado atual da entidade
        System.out.println("Current State:");
        System.out.println(aggregate.getCurrentState());
    }
}

