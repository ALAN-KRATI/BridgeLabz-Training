public class CircularRoundabout {

    private Vehicle head = null;

    public void addVehicle(String number){
        Vehicle newVehicle = new Vehicle(number);

        if(head == null){
            head = newVehicle;
            newVehicle.next = head;
        }
        else{
            Vehicle temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }

        System.out.println("Vehicle entered roundabout: " + number);
    }

    public void removeVehicle(String number) {
        if (head == null) {
            System.out.println("Roundabout empty.");
            return;
        }
    
            Vehicle curr = head;
            Vehicle prev = null;
    
            do {
                if (curr.number.equals(number)) {
    
                    if (prev != null) {
                        prev.next = curr.next;
                    }
    
                    if (curr == head) {
                        Vehicle last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
    
                    System.out.println("Vehicle exited roundabout: " + number);
                    return;
                }
    
                prev = curr;
                curr = curr.next;
    
            } while (curr != head);
    
            System.out.println("Vehicle not found.");
        }
    
    // Display roundabout
    public void display() {
            if (head == null) {
                System.out.println("Roundabout is empty.");
                return;
            }
    
            Vehicle temp = head;
            System.out.print("Roundabout: ");
            do {
                System.out.print(temp.number + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(back to start)");
    }
}
