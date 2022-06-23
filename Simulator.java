/*BIL122 - Lab 6
 @furkanrmk Furkan IRMAK, <furkanirmak81@gmail.com>
*/
public class Simulator{
    public static void main(String[] args){
        DoorMan[] doormen;
        Slayer slayer;
        ZombieCounter zc = new ZombieCounter();
        slayer= new Slayer(zc);
        int n = Integer.parseInt(args[0]);
        doormen = new DoorMan[n];
        for(int i=0; i < n; i++){
            doormen[i] = new DoorMan(zc);
        }
        for (int i=0; i<n;i++){
            doormen[i].start();
        }
        slayer.start();

        try{
            slayer.join();
            for(int i=0; i < n;i++){
                doormen[i].join();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Game Over!\n"+"you"+(zc.getKilledCount() >=100? "won": "lost!"));
        System.out.println("number of zombies:"+ zc.getInTheRoomCount());
        System.out.println("number of killed:"+ zc.getKilledCount());
    }
}