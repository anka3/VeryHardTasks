import java.util.Objects;

public class Employer {
    public String name;

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                '}';
    }

    public Employer(String name) {
        this.name = name;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(name, employer.name);
    }
    // он сравнивает только имена! он проверяет что ссылка на объект одинаковая (по умолчанию)

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //для одинаковых обьектов он выделяет одинаковый хешкод потому что у меня хеш на основе имени
}
