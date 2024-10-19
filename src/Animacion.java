public class Animacion extends Thread{
    Reloj reloj;
    public int time[] = {2, 59, 55};

    public Animacion(Reloj reloj){
        this.reloj = reloj;
    }

    public void setTime(){
        time[2]++; //Sumar segundos
        if(time[2] >= 60){
            time[1]++; //Sumar minutos
            time[2] = 0;

            if(time[1] >= 59){
                time[0]++; //Sumar horas
                time[1] = 0;
            }
        }

    }

    @Override
    public void run(){
        while(true){

            try {
                reloj.updateTime(time);
                sleep(1000);
                setTime();
            } catch (InterruptedException e) {

            }
        }
    }
}
