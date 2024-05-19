package pacote1;

import java.util.Random;
import java.util.Scanner;


public class principal {

    //Status do personagem principal
    public static int hp = 40, ataque = 5, velocidade = 12, defesa =5,xp=0;

    //Status dos inimigos

    public static int inihp = 20, iniataque = 5, inivelocidade = 5 , inidefesa = 5;






        public static void main(String[] args) {
            String nome;
            int menuclass = 0, caminho1=0;

            Scanner receber = new Scanner(System.in);

            System.out.println("Insira o nome do personagem");
            nome = receber.next();



            while (menuclass != 1 && menuclass != 2 && menuclass != 3 && menuclass != 4) {
                System.out.println("selecione a classe do personagem \n1-Guerreiro \n2-Ladrão \n3-Barbaro \n4-Druida");
                menuclass = receber.nextInt();
                switch (menuclass) {
                    case 1:
                        System.out.println("Você escolheu a classe Guerreiro");
                         ataque+=2;
                        break;
                    case 2:
                        System.out.println("Você escolheu a classe Ladrão");
                        velocidade+=2;
                        break;

                    case 3:
                        System.out.println("Você escolheu a classe Barbaro");
                        defesa+=2;
                        break;

                    case 4:
                        System.out.println("Você escolheu a classe Druida");
                        hp+=2;
                        break;

                    default:
                        System.out.println("você digitou uma opção invalida");
                        break;

                }
            }
            System.out.printf("Bem vindo jogador %s\n", nome);

            System.out.println("Em uma casa no meio da floresta, você é acordado com uma sensação de inquitação");
            System.out.println("Então decide vasculhar a casa... acaba se assustando ao descobrir que o mundo ao seu redor mudou drasticamente");
            System.out.println("Vultos e sons perturbadores preenchem o ambiente...");
            System.out.println("Ao olhar pela janela, se depara com um cenário estranho e surreal, completamente diferente do que estava habituado.");
            System.out.println();
            System.out.println("Então decide sair da casa, para encontrar uma maneira de sair desse pesadelo...");
            System.out.println("Depois de sair de casa e ver que tudo está diferente você está em uma floresta e tem dois caminho para onde ir");
            System.out.println();

            do {
                System.out.println("Primeira ação  digite a sua escolha (1) direita ou (2) esquerda?");
                caminho1 = receber.nextInt();
                switch (caminho1) {
                    case 1:
                        System.out.println("você encontrou aranha nivel 1\n ");
                        break;
                    case 2:
                        System.out.println("você encontrou aranha nivel 2\n");
                        break;
                    default:
                        System.err.println("entrada de dados invalida");
                        break;

                }

            } while (caminho1 != 1 && caminho1 !=2);

            System.out.println("você encontrou o inimigo");
            if (velocidade > inivelocidade) {
                lutanivel1();
            } else {
                lutaininivel1();
            }
            subirnivel();



            randomizarstatusini();
            System.out.println("você encontrou o inimigo 2");
            if (velocidade > inivelocidade) {
                lutanivel1();
            } else {
                lutaininivel1();
            }
            informacoes();
        }

    public static void subirnivel(){
            if(xp>50){
                hp +=2;
                ataque +=2;
                defesa +=2;
                velocidade +=2;
            }
    }
    public static int ataqueinimigo() {
        Random gerador = new Random();
        return gerador.nextInt(2);

    }

    public static int geradorxp() {
        Random gerar = new Random();
        return gerar.nextInt((100 - 50) + 1) + 50;

    }
    public static void informacoes(){
        System.out.printf("vida %d\n",hp);
        System.out.printf("ataque %d\n",ataque);
        System.out.printf("defesa %d\n",defesa);
        System.out.printf("velocidade %d\n", velocidade);
    }
    public static void randomizarstatusini(){
            Random gerador = new Random();
            inihp = gerador.nextInt((10 - 9) + 1) + 9;
            iniataque = gerador.nextInt((10 - 9) + 1) + 9;
            inidefesa =  gerador.nextInt((10 - 9) + 1) + 9;
            inivelocidade = gerador.nextInt((10 - 9) + 1) + 9;
    }

    public static void lutanivel1() {
        Scanner receber = new Scanner(System.in);
        int escolha = 0;


        do {
            System.out.println("==================================================================");
            System.out.println("você entrou no combate selecione a opção para (1) atacar ou (2) correr");
            System.out.println("==================================================================");
            System.out.printf("vida do usuario %d\n", hp);
            System.out.printf("vida do inimigo %d\n", inihp);

            escolha = receber.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("você atacou o inimigo");
                    inihp -= ataque / 2;
                    break;

                case 2:
                    System.out.println("você correu");
                    break;

                default:
                    System.err.println("opção invalida digite a opção novamente");
                    break;
            }
            if (escolha != 2) {
                if (inihp > 0) {
                    escolha = ataqueinimigo();
                    switch (escolha) {
                        case 0:
                            System.out.println("O inimigo aplicou um ataque");
                            hp -= iniataque / 2;
                            break;
                        case 1:
                            System.out.println("O inimigo errou o ataque");
                            break;
                    }
                }
            }

        } while (hp > 0 && inihp > 0 && escolha != 2);


        if (escolha == 2) {
            System.out.println("você fugiu do combate");
        } else if (hp <= 0) {
            System.out.println("você foi derrotado");
        } else {
            System.out.println("você derrotou o inimigo");
            xp = geradorxp();
            System.out.printf("Você ganhou %d de xp\n",xp);
        }
    }

    public static void lutaininivel1() {
        Scanner receber = new Scanner(System.in);
        int escolha = 0, escolhaini = 0;
        ;

        //personagem




        while (hp > 0 && inihp > 0 && escolha != 2) {
            System.out.println("==================================================================");
            System.out.println("você entrou no combate selecione a opção para (1) atacar ou (2) correr");
            System.out.println("==================================================================");
            System.out.printf("vida do usuario %d\n", hp);
            System.out.printf("vida do inimigo %d\n", inihp);

            escolha = receber.nextInt();
            if (escolhaini != 2) {
                if (inihp > 0) {
                    escolhaini = ataqueinimigo();
                    switch (escolhaini) {
                        case 0:
                            System.out.println("O inimigo aplicou um ataque");
                            hp -= iniataque / 2;
                            break;
                        case 1:
                            System.out.println("O inimigo errou o ataque");
                            break;
                    }
                }
            }
            switch (escolha) {
                case 1:
                    System.out.println("você atacou o inimigo");
                    inihp -= ataque / 2;
                    break;

                case 2:
                    System.out.println("você fugiu vacilão");
                    break;

                default:
                    System.err.println("opção invalida digite a opção novamente");
                    break;
            }

        }

        if (escolha == 2) {
            System.out.println("você fugiu do combate");
        } else if (hp <= 0) {
            System.out.println("você foi derrotado");
        } else {
            System.out.println("você derrotou o inimigo");
            xp = geradorxp();
            System.out.printf("Você ganhou %d",xp,"de xp\n");
        }


    }
    }
