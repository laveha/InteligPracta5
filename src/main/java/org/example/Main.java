import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game {
    private int powerPoints;
    private int speedPoints;
    private int agilityPoints;
    private String zombieName;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        initializePoints();

        System.out.print("Введите ФИО покойника: ");
        zombieName = scanner.nextLine();

        System.out.println("Вдруг покойника воскрешает профессор Зомбу");
        ZombieDescription();
        System.out.println("\nВыберите тип зомби, каким хотите стать: ");
        System.out.println("1. Зомби обычный");
        System.out.println("2. Зомби с ведром на голове");
        System.out.println("3. Зомби-футболист");
        System.out.println("4. Зомби-плавец");
        System.out.print("Выбор: ");
        int zombieType = scanner.nextInt();
        chooseZombieType(zombieType);

        System.out.println("\nВыберите бонус: ");
        BonusDescription();
        System.out.println("1. Действие");
        System.out.println("2. Скорость");
        System.out.println("3. Ловкость");
        System.out.print("Выбор: ");
        int bonusType = scanner.nextInt();
        updatePoints(bonusType);

        System.out.println("\nСловно во время высадки в Нормандию ваш зомби отправляется в бой.");
        System.out.println("Проходя мимо могил, вы выходите к пустующей площадке с высаженными растениями.");
        System.out.println("Чтобы пройти дальше в город, вам необходимо уничтожить одно из растений.");
        selectOpponent();

        if (powerPoints <= 0) {
            System.out.println("Game over :(");
        } else {
            System.out.println("\nОдолев одно из растений, вы продвигаетесь дальше.");
        }

        System.out.println("\nВы наступаете на капкан.");
        System.out.println("Выберите бонус для списания: ");
        updatePoints(scanner.nextInt());

        System.out.println("\nВторое поле битвы содержит кактусомет, горохострел и подсолнух.");
        System.out.println("Кого атакуете?");
        selectNewOpponent();
        System.out.println("\nЗа успешную победу вы получаете дополнительное повышение очков действия/скорости/ловкости.");
        BonusChoice(scanner.nextInt());

        System.out.println("\nОдолев противника, вы находите выход с кладбища. Ваш зомби направляется в город.");
        displayResults();
    }

    private void initializePoints() {
        powerPoints = 0;
        speedPoints = 0;
        agilityPoints = 0;
    }

    private void chooseZombieType(int zombieType) {
        switch (zombieType) {
            case 1:
                System.out.println("Один из самых худших зомби. +1 очко действия");
                powerPoints += 1;
                break;
            case 2:
                System.out.println("Зомби с ведром на голове. +2 очка действия");
                powerPoints += 2;
                break;
            case 3:
                System.out.println("Зомби-футболист. +3 очка действия");
                powerPoints += 3;
                break;
            case 4:
                System.out.println("Зомби-плавец. +4 очка действия");
                powerPoints += 4;
                break;
            default:
                System.out.println("Обычный зомби. +1 очко действия");
                powerPoints += 1;
                break;
        }
    }

    private void updatePoints(int bonusType) {
        switch (bonusType) {
            case 1:
                powerPoints += 1;
                System.out.println("Очки действия увеличены на 1");
                break;
            case 2:
                speedPoints += 1;
                System.out.println("Скорость увеличена на 1");
                break;
            case 3:
                agilityPoints += 1;
                System.out.println("Ловкость увеличена на 1");
                break;
            default:
                System.out.println("Продолжим без изменений");
                break;
        }
    }

    private void selectOpponent() {
        System.out.println("\n1. Бомба-гриб");
        System.out.println("2. Гриб-метатель");
        System.out.println("3. Живая лампа");
        System.out.print("Выбор: ");
        int opponent = scanner.nextInt();
        switch (opponent) {
            case 1:
                System.out.println("Бомба-гриб взрывается через 3 секунды.");
                if (speedPoints == 1) {
                    System.out.println("Успешно убежали. -1 очко действия");
                    powerPoints -= 1;
                } else {
                    System.out.println("Вас задел взрыв. -2 очка действия");
                    powerPoints -= 2;
                }
                break;
            case 2:
                System.out.println("Гриб-метатель стреляет по вам 3 раза.");
                if (agilityPoints == 1) {
                    System.out.println("Уклонились от выстрелов. -1 очко действия");
                    powerPoints -= 1;
                } else {
                    System.out.println("Вас попали все выстрелы. -2 очка действия");
                    powerPoints -= 2;
                }
                break;
            case 3:
                System.out.println("Живая лампа не может дать отпор. -1 очко действия");
                powerPoints -= 1;
                break;
            default:
                System.out.println("Продолжим без изменений");
                break;
        }
    }

    private void selectNewOpponent() {
        System.out.println("\n1. Кактусомет");
        System.out.println("2. Горохострел");
        System.out.println("3. Подсолнух");
        System.out.print("Выбор: ");
        int opponent = scanner.nextInt();
        switch (opponent) {
            case 1:
                System.out.println("Кактусомет взрывается через 3 секунды.");
                if (speedPoints == 1) {
                    System.out.println("Успешно убежали. -1 очко действия");
                    powerPoints -= 1;
                } else {
                    System.out.println("Вас задел взрыв. -2 очка действия");
                    powerPoints -= 2;
                }
                break;
            case 2:
                System.out.println("Горохострел стреляет по вам 3 раза.");
                if (agilityPoints == 1) {
                    System.out.println("Уклонились от выстрелов. -1 очко действия");
                    powerPoints -= 1;
                } else {
                    System.out.println("Вас попали все выстрелы. -2 очка действия");
                    powerPoints -= 2;
                }
                break;
            case 3:
                System.out.println("Подсолнух не может дать отпор. -1 очко действия");
                powerPoints -= 1;
                break;
            default:
                System.out.println("Продолжим без изменений");
                break;
        }
    }

    private void ZombieDescription() {
        System.out.println("\n1. Зомби обычный - ничем не примечательный зомби");
        System.out.println("2. Зомби с ведром на голове - отличается бронированностью");
        System.out.println("3. Зомби-футболист - в прошлом был спортивным человеком");
        System.out.println("4. Зомби-плавец - не отличается от зомби-футболиста");
    }

    private void BonusDescription() {
        System.out.println("\n1. Очки действия показывают вашу способность действовать");
        System.out.println("2. Скорость - позволяет убежать от взрыва");
        System.out.println("3. Ловкость - способность уворачиваться от снарядов");
    }

    private void BonusChoice(int bonusType) {
        switch (bonusType) {
            case 1:
                powerPoints += 1;
                System.out.println("Очки действия увеличены на 1");
                break;
            case 2:
                speedPoints += 1;
                System.out.println("Скорость увеличена на 1");
                break;
            case 3:
                agilityPoints += 1;
                System.out.println("Ловкость увеличена на 1");
                break;
            default:
                System.out.println("Продолжим без изменений");
                break;
        }
    }

    private void displayResults() {
        System.out.println("\nИгра окончена!");
        System.out.println("ФИО зомби: " + zombieName);
        System.out.println("Накопленные очки: ");
        System.out.println("Очки действия - " + powerPoints);
        System.out.println("Скорость - " + speedPoints);
        System.out.println("Ловкость - " + agilityPoints);
    }
}