/*BIL122 - Lab 6
 @furkanrmk Furkan IRMAK, <furkanirmak81@gmail.com>
*/
public class DoorMan extends Thread{
    ZombieCounter zc;
    public DoorMan(ZombieCounter zombieCounter){
        this.zc=zombieCounter;
    }
    @Override
    public void run(){
        while(!zc.tooManyZombiesInTheRoom() && !zc.killed100Zombies()){
            double r=Math.random();
            if(r<0.5){
                zc.zombieEntered();
            }
            try{
                Thread.sleep(2);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}