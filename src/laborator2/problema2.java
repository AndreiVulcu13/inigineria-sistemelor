package laborator2;

// Interfață pentru noduri
interface Node {
    int getValue();
    void setValue(int val);
}

// Nod pentru lista simplu înlănțuită
class SimpleChainedNode implements Node {
    private int value;
    private SimpleChainedNode next;

    public SimpleChainedNode(int value) {
        this.value = value;
        this.next = null;
    }

    public void setNextNode(SimpleChainedNode next) {
        this.next = next;
    }

    public SimpleChainedNode getNextNode() {
        return next;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}

// Clasă pentru lista simplu înlănțuită
class SimpleChainedList {
    private SimpleChainedNode head;

    public void addValue(int value) {
        if (head == null) {
            head = new SimpleChainedNode(value);
        } else {
            SimpleChainedNode temp = head;
            while (temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(new SimpleChainedNode(value));
        }
    }

    public void removeNodeByValue(int value) {
        if (head == null) return;
        if (head.getValue() == value) {
            head = head.getNextNode();
            return;
        }
        SimpleChainedNode temp = head;
        while (temp.getNextNode() != null && temp.getNextNode().getValue() != value) {
            temp = temp.getNextNode();
        }
        if (temp.getNextNode() != null) {
            temp.setNextNode(temp.getNextNode().getNextNode());
        }
    }

    public void listNodes() {
        SimpleChainedNode temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNextNode();
        }
        System.out.println("null");
    }
}

// Clasa Application pentru testare
class Application1 {
    public static void main(String[] args) {
        SimpleChainedList simpleList = new SimpleChainedList();

        // Adăugăm valori
        for (int i = 1; i <= 10; i++) {
            simpleList.addValue(i);
        }
        System.out.println("Lista inițială:");
        simpleList.listNodes();

        // Ștergem elementele 4, 6, 8, 10
        simpleList.removeNodeByValue(4);
        simpleList.removeNodeByValue(6);
        simpleList.removeNodeByValue(8);
        simpleList.removeNodeByValue(10);

        System.out.println("Lista după ștergeri:");
        simpleList.listNodes();
    }
}

