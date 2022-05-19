package com.vex.vexillum.model;

import com.vex.vexillum.complete.CompleteApplication;
import com.vex.vexillum.level.LevelApplication;
import com.vex.vexillum.menu.MenuApplication;
import com.vex.vexillum.stats.StatsApplication;
import com.vex.vexillum.winlose.WinLoseApplication;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Model {

    public static int levelFlag; // 1 - flags, 2 - facts, 3 - maps

    public static int backFlag; // 1 - menu, 2 - win/lose screen

    public static int winningButton;

    public static int chosenCountry;

    public static boolean completeFlag = false;

    public static boolean completeFact = false;

    public static boolean completeMap = false;

    public static boolean answerFlag; // true - right, false - wrong

    public static boolean oneTimeFlag = false;

    public static final int levelCount = 65;

    public static final String[] countries = new String[]{
            "Албания",
            "Аргентина",
            "Армения",
            "Австралия",
            "Австрия",
            "Азербайджан",
            "Белоруссия",
            "Бутан",
            "Босния и Герцеговина",
            "Бразилия",
            "Великобритания",
            "Болгария",
            "Канада",
            "Чили",
            "Китай",
            "Колумбия",
            "Куба",
            "Кипр",
            "Доминикана",
            "Египет",
            "Финляндия",
            "Франция",
            "Грузия",
            "Германия",
            "Греция",
            "Гаити",
            "Индия",
            "Иран",
            "Ирак",
            "Ирландия",
            "Израиль",
            "Италия",
            "Япония",
            "Казахстан",
            "Корея",
            "Ливан",
            "Либерия",
            "Ливия",
            "Мадагаскар",
            "Мексика",
            "Монголия",
            "Черногория",
            "Марокко",
            "Непал",
            "Нигерия",
            "Пакистан",
            "Панама",
            "Папуа-Новая Гвенея",
            "Польша",
            "Румыния",
            "Россия",
            "ЮАР",
            "Сербия",
            "Сомали",
            "Испания",
            "Шри-Ланка",
            "Швеция",
            "Швейцария",
            "Тайланд",
            "Тунис",
            "Украина",
            "США",
            "Венесуэла",
            "Вьетнам",
            "Эфиопия"
    };

    public static final String[] pathFlags = new String[]{
            "images/flags/AlbaniaFlagImage.png",
            "images/flags/ArgentinaFlagImage.png",
            "images/flags/ArmeniaFlagImage.png",
            "images/flags/AustraliaFlagImage.png",
            "images/flags/AustriaFlagImage.png",
            "images/flags/AzerbaijanFlagImage.png",
            "images/flags/BelarusFlagImage.png",
            "images/flags/BhutanFlagImage.png",
            "images/flags/BosniaFlagImage.png",
            "images/flags/BrazilFlagImage.png",
            "images/flags/BritainFlagImage.png",
            "images/flags/BulgariaFlagImage.png",
            "images/flags/CanadaFlagImage.png",
            "images/flags/ChileFlagImage.png",
            "images/flags/ChinaFlagImage.png",
            "images/flags/ColombiaFlagImage.png",
            "images/flags/CubaFlagImage.png",
            "images/flags/CyprusFlagImage.png",
            "images/flags/DominicaFlagImage.png",
            "images/flags/EgyptFlagImage.png",
            "images/flags/FinlandFlagImage.png",
            "images/flags/FranceFlagImage.png",
            "images/flags/GeorgiaFlagImage.png",
            "images/flags/GermanyFlagImage.png",
            "images/flags/GreeceFlagImage.png",
            "images/flags/HaitiFlagImage.png",
            "images/flags/IndiaFlagImage.png",
            "images/flags/IranFlagImage.png",
            "images/flags/IraqFlagImage.png",
            "images/flags/IrelandFlagImage.png",
            "images/flags/IsraelFlagImage.png",
            "images/flags/ItalyFlagImage.png",
            "images/flags/JapanFlagImage.png",
            "images/flags/KazakhstanFlagImage.png",
            "images/flags/KoreaFlagImage.png",
            "images/flags/LebanonFlagImage.png",
            "images/flags/LiberiaFlagImage.png",
            "images/flags/LibyaFlagImage.png",
            "images/flags/MadagascarFlagImage.png",
            "images/flags/MexicoFlagImage.png",
            "images/flags/MongoliaFlagImage.png",
            "images/flags/MontenegroFlagImage.png",
            "images/flags/MoroccoFlagImage.png",
            "images/flags/NepalFlagImage.png",
            "images/flags/NigeriaFlagImage.png",
            "images/flags/PakistanFlagImage.png",
            "images/flags/PanamaFlagImage.png",
            "images/flags/PapuaNewGuineaFlagImage.png",
            "images/flags/PolandFlagImage.png",
            "images/flags/RomaniaFlagImage.png",
            "images/flags/RussiaFlagImage.png",
            "images/flags/SARFlagImage.png",
            "images/flags/SerbiaFlagImage.png",
            "images/flags/SomaliaFlagImage.png",
            "images/flags/SpainFlagImage.png",
            "images/flags/SriLankaFlagImage.png",
            "images/flags/SwedenFlagImage.png",
            "images/flags/SwitzerlandFlagImage.png",
            "images/flags/ThailandFlagImage.png",
            "images/flags/TunisiaFlagImage.png",
            "images/flags/UkraineFlagImage.png",
            "images/flags/USAFlagImage.png",
            "images/flags/VenezuelaFlagImage.png",
            "images/flags/VietnamFlagImage.png",
            "images/flags/EthiopiaFlagImage.png"
    };

    public static final String[] pathMaps = new String[]{
            "images/maps/AlbaniaMapImage.png",
            "images/maps/ArgentinaMapImage.png",
            "images/maps/ArmeniaMapImage.png",
            "images/maps/AustraliaMapImage.png",
            "images/maps/AustriaMapImage.png",
            "images/maps/AzerbaijanMapImage.png",
            "images/maps/BelarusMapImage.png",
            "images/maps/BhutanMapImage.png",
            "images/maps/BosniaMapImage.png",
            "images/maps/BrazilMapImage.png",
            "images/maps/BritainMapImage.png",
            "images/maps/BulgariaMapImage.png",
            "images/maps/CanadaMapImage.png",
            "images/maps/ChileMapImage.png",
            "images/maps/ChinaMapImage.png",
            "images/maps/ColombiaMapImage.png",
            "images/maps/CubaMapImage.png",
            "images/maps/CyprusMapImage.png",
            "images/maps/DominicanRepublicMapImage.png",
            "images/maps/EgyptMapImage.png",
            "images/maps/FinlandMapImage.png",
            "images/maps/FranceMapImage.png",
            "images/maps/GeorgiaMapImage.png",
            "images/maps/GermanyMapImage.png",
            "images/maps/GreeceMapImage.png",
            "images/maps/HaitiMapImage.png",
            "images/maps/IndiaMapImage.png",
            "images/maps/IranMapImage.png",
            "images/maps/IraqMapImage.png",
            "images/maps/IrelandMapImage.png",
            "images/maps/IsraelMapImage.png",
            "images/maps/ItalyMapImage.png",
            "images/maps/JapanMapImage.png",
            "images/maps/KazakhstanMapImage.png",
            "images/maps/KoreaMapImage.png",
            "images/maps/LebanonMapImage.png",
            "images/maps/LiberiaMapImage.png",
            "images/maps/LibyaMapImage.png",
            "images/maps/MadagascarMapImage.png",
            "images/maps/MexicoMapImage.png",
            "images/maps/MongoliaMapImage.png",
            "images/maps/MontenegroMapImage.png",
            "images/maps/MoroccoMapImage.png",
            "images/maps/NepalMapImage.png",
            "images/maps/NigeriaMapImage.png",
            "images/maps/PakistanMapImage.png",
            "images/maps/PanamaMapImage.png",
            "images/maps/PapuaNewGuineaMapImage.png",
            "images/maps/PolandMapImage.png",
            "images/maps/RomaniaMapImage.png",
            "images/maps/RussiaMapImage.png",
            "images/maps/SARMapImage.png",
            "images/maps/SerbiaMapImage.png",
            "images/maps/SomaliaMapImage.png",
            "images/maps/SpainMapImage.png",
            "images/maps/SriLankaMapImage.png",
            "images/maps/SwedenMapImage.png",
            "images/maps/SwitzerlandMapImage.png",
            "images/maps/ThailandMapImage.png",
            "images/maps/TunisiaMapImage.png",
            "images/maps/UkraineMapImage.png",
            "images/maps/USAMapImage.png",
            "images/maps/VenezuelaMapImage.png",
            "images/maps/VietnamMapImage.png",
            "images/maps/EthiopiaMapImage.png",
    };

    public static final String[] facts = new String[]{
            "В этой стране родилась Мать Тереза", // Албания
            "В этой стране находится самый южный город в мире", // Аргентина
            "В этой стране христианство\nвпервые стало государственной религией", // Армения
            "Первоначально земля, где находится эта страна,\nбыла названа Новой Голландией", // Австралия
            "В этой стране родился\nголливудский актер Арнольд Шварцнегер", // Австрия
            "Девиз этой страны: «Страна огней»", // Азербайджан
            "В этой стране производится\nсамый большой самосвал в мире", // Белоруссия
            "Самоназвание этой страны — Друк Юл,\nчто в переводе означает\n«страна дракона-громовержца»", // Бутан
            "После захвата этой страны\nОсманской империей в 1463 году,\nвсе её жители обратились в мусульманство", // Босния и Герцеговина
            "Названия этой страны и её столицы совпадают", // Бразилия
            "Эта страна была крупнейшей\nколониальной империей\nза всю историю человечества,\nс колониями на всех континентах", // Великобритания
            "В этой стране сохранилось старейшее здание\nна Балканском полуострове – жилой дом,\nкоторый датируется X-XII веками,\nбыл возведен еще во времена Византийской империи", // Болгария
            "Граница между этой страной и её соседом США\n- самая длинная из существующих на планете", // Канада
            "Это самая вытянутая страна в мире", // Чили
            "Все панды мира принадлежат этой стране", // Китай
            "В этой стране добывается 90% изумрудов", // Колумбия
            "В этой стране кока-кола вне закона", // Куба
            "По одной из версий,\nназвание этой страны произошло от слова «медь»", // Кипр
            "В этой стране снимался знаменитый фильм\n«Парк Юрского периода»", // Доминикана
            "В этой стране находится пирамида Хиопса", // Египет
            "По статистике в этой стране\nна трех человек приходиться одна сауна", // Финляндия
            "В этой стране находится самое\nбольшое количество замков в мире", // Франция
            "Житили этой страны называют её «Сакартвело»", // Грузия
            "В этой стране больше\n1000 видов колбас и 5000 сортов пива", // Германия
            "В этой стране есть гора,\n на которой женщинам запрещено находится", // Греция
            "Название этой страны\nпроисходит от «Айти» — «Земля гор»", // Гаити
            "В этой стране проживает\nбольше всего людей на Земле", // Индия
            "Эту страну часто путают с Ираком", // Иран
            "Эту страну часто путают с Ираном", // Ирак
            "Главные символы этой страны – клевер и арфа", // Ирландия
            "В этой стране самый высокий в мире\nпроцент людей с высшим образованием", // Израиль
            "На территории этой страны расположены\nдва карликовых государства: Сан-Марино и Ватикан", // Италия
            "Эта страна - родина Аниме и самураев", // Япония
            "В этой стране находится космодром Байконур", // Казахстан
            "Эта страна родина киберспорта и тхэквондо", // Корея
            "Символ этой страны - кедр", // Ливан
            "Эта страна была основана\nчернокожими поселенцами из Америки", // Либерия
            "Эта страна - родина Муаммара Каддафи", // Ливия
            "Эта страна - лидер по\nпроизводству натуральной ванили", // Мадагаскар
            "Эта страна - родина\nперца чили, шоколада и кукурузы", // Мексика
            "Древний правитель этой страны за 25 лет\nсумел завоевать больше земель и народов,\nчем солдаты Римской империи за 400 лет", // Монголия
            "Жители этой страны самые рослые в Европе ", // Черногория
            "В этой стране находится\nсамый старый в мире университет", // Марокко
            "Эта страна - родина Будды", // Непал
            "В этой стране проживает\nбольше всего людей в Африке", // Нигерия
            "В колониальные времена эта страна\nсчиталась частью Индии", // Пакистан
            "Эта страна известна своим судоходным каналом,\nназванным в её честь", // Панама
            "Эта страна самая многоязычная страна на свете", // Папуа-Новая Гвенея
            "Театров в этой стране больше, чем кинотеатров", // Польша
            "Эта страна - родина Влада Цепеша", // Румыния
            "Это самая большая страна в мире", // Россия
            "У этой страны три столицы:\nадминистративная, законодательная и судебная", // ЮАР
            "Эта страна - родина Николы Теслы", // Сербия
            "В этой стране есть мужское имя «Калаш»,\nобразованное от азвания автомата Калашникова", // Сомали
            "Символ этой страны - бык", // Испания
            "Эта страна была португальской,\nголландской и английской колонией", // Шри-Ланка
            "Эта страна - родина спичек", // Швеция
            "В этой стране четыре официальных языка:\nнемецкий, французский, итальянский и романшский", // Швейцария
            "Эта страна - единственная в Юго-Восточной Азии,\n которая никогда не была колонией", // Тайланд
            "В этой стране находится древний город Карфаген", // Тунис
            "В этой стране разработали самолет\n с наибольшей в мире грузоподъемностью", // Украина
            "Эта страна - родина Голливуда и ковбоев", // США
            "Название этой страны означает «маленькая Венеция»", // Венесуэла
            "Эта страна - родина Хо Ши Мина", // Вьетнам
            "Эта страна - родина Хайле Селассие" // Эфиопия
    };

    public Model() {
    }

    //Всё что связано с stats.txt

    public static int[] stats; // right flags, wrong flags, right facts, wrong facts, right maps, wrong maps

    static {
        try {
            stats = getStats();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] getStats() throws FileNotFoundException {
        int[] nums = new int[6];
        File file = new File("src\\main\\resources\\com\\vex\\vexillum\\file\\stats.txt");
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < 6; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    public static int getRightFlags() throws FileNotFoundException {
        return getStats()[0];
    }

    public static int getWrongFlags() throws FileNotFoundException {
        return getStats()[1];
    }

    public static int getAllFlags() throws FileNotFoundException {
        return getRightFlags() + getWrongFlags();
    }

    public static int getRightFacts() throws FileNotFoundException {
        return getStats()[2];
    }

    public static int getWrongFacts() throws FileNotFoundException {
        return getStats()[3];
    }

    public static int getAllFacts() throws FileNotFoundException {
        return getRightFacts() + getWrongFacts();
    }

    public static int getRightMaps() throws FileNotFoundException {
        return getStats()[4];
    }

    public static int getWrongMaps() throws FileNotFoundException {
        return getStats()[5];
    }

    public static int getAllMaps() throws FileNotFoundException {
        return getRightMaps() + getWrongMaps();
    }

    public static int getAllRights() throws FileNotFoundException {
        return getRightMaps() + getRightFlags() + getRightFacts();
    }

    public static int getAllWrongs() throws FileNotFoundException {
        return getWrongMaps() + getWrongFlags() + getWrongFacts();
    }

    public static int getAllAll() throws FileNotFoundException {
        return getAllRights() + getAllWrongs();
    }

    public static void changeNum(int num, int i) {
        int[] nums = stats;
        nums[i] = num;
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\file\\stats.txt", false)) {
            for (int l = 0; l < 6; l++) {
                String number = Integer.toString(nums[l]);
                writer.write(number + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stats = nums;
    }

    //Всё что связано с map/flag/facStats.txt

    public static int[] flagStats;

    static {
        try {
            flagStats = getLevelStats(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] factStats;

    static {
        try {
            factStats = getLevelStats(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] mapStats;

    static {
        try {
            mapStats = getLevelStats(3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] getLevelStats(int levelFlag) throws FileNotFoundException {
        int[] nums = new int[levelCount];
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < levelCount; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    public static void changeLevelStat(int num, int i, int levelFlag) throws FileNotFoundException {
        int[] nums = getLevelStats(levelFlag);
        nums[i] = num;
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < levelCount; l++) {
                String number = Integer.toString(nums[l]);
                writer.write(number + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        switch (levelFlag) {
            case 1 -> flagStats = nums;
            case 2 -> factStats = nums;
            default -> mapStats = nums;
        }
    }

    public static void resetLevel(int levelFlag) throws FileNotFoundException {
        int[] nums = getLevelStats(levelFlag);
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < levelCount; l++) {
                writer.write(0 + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        switch (levelFlag) {
            case 1 -> flagStats = nums;
            case 2 -> factStats = nums;
            default -> mapStats = nums;
        }
    }

    //Кнопки

    public static void backButton(Button backButton) throws IOException {
        if (backFlag == 1) {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            MenuApplication app = new MenuApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }

    }

    public static void statsButton(Button statsButton) throws IOException {
        Stage stage = (Stage) statsButton.getScene().getWindow();
        StatsApplication app = new StatsApplication();
        app.start(stage);
    }

    public static void levelButton(Button levelButton) throws IOException {
        if (getCompleted() == levelCount) {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            LevelApplication app = new LevelApplication();
            app.start(stage);
        }
    }

    public static void rightButton(Button rightButton) throws IOException {
        answerFlag = true;
        int i = switch (levelFlag) {
            case 1 -> 0;
            case 2 -> 2;
            default -> 4;
        };
        rightWrongButton(rightButton, i);
    }

    public static void wrongButton(Button wrongButton) throws IOException {
        answerFlag = false;
        int i = switch (levelFlag) {
            case 1 -> 1;
            case 2 -> 3;
            default -> 5;
        };
        rightWrongButton(wrongButton, i);
    }

    private static void rightWrongButton(Button button, int i) throws IOException {
        switch (levelFlag) {
            case 1 -> changeLevelStat(1, chosenCountry, 1);
            case 2 -> changeLevelStat(1, chosenCountry, 2);
            default -> changeLevelStat(1, chosenCountry, 3);
        }
        int num = Model.stats[i];
        changeNum(num + 1, i);
        if (getCompleted() == levelCount) {
            Stage stage = (Stage) button.getScene().getWindow();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }
    }

    private static int getCompleted() throws FileNotFoundException {
        return switch (levelFlag) {
            case 1 -> getAllFlags();
            case 2 -> getAllFacts();
            default -> getAllMaps();
        };
    }

    //Рандомайзер

    public static int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    //Рандомайзер уровней

    public static int levelRandomizer() {
        int i = randomizer(0, levelCount - 1);
        int[] levels = switch (levelFlag) {
            case 1 -> flagStats;
            case 2 -> factStats;
            default -> mapStats;
        };
        if (levels[i] == 1) {
            for (int l = i; l < levelCount; l++) {
                if (levels[l] == 0) {
                    i = l;
                    break;
                }
            }
            for (int l = i; l > 0; l--) {
                if (levels[l] == 0) {
                    i = l;
                    break;
                }
            }
        }
        return i;
    }

    //Рандомайзер кнопок

    public static int[] buttonsRandomizer(int i) {
        int[] nums = new int[levelCount];
        nums[i] = 1;
        for (int l = 0; l < levelCount - 5; l++) {
            int randomNum = randomizer(0, levelCount - 1);
            nums[randomNum] = 1;
        }
        int[] buttons = new int[3];
        buttons[0] = buttonRandomizer(i, nums);
        nums[buttons[0]] = 1;
        buttons[1] = buttonRandomizer(i, nums);
        nums[buttons[1]] = 1;
        buttons[2] = buttonRandomizer(i, nums);
        return buttons;
    }

    private static int buttonRandomizer(int i, int[] nums) {
        int button = 0;
        for (int l = i; l < levelCount; l++) {
            if (nums[l] == 0) {
                button = l;
                break;
            }
        }
        if (button == 0) {
            for (int l = i; l > 0; l--) {
                if (nums[l] == 0) {
                    button = l;
                    break;
                }
            }
        }
        return button;
    }

}
