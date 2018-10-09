package sqlJdbc.testex.parser.object;


import java.util.Objects;


public class Vacancy {
    /**
     * уникальное число значения объекта
     */
    private int hash;

    private final  String author;
    private final String vacancyType;
    private final String create;



    public Vacancy(final String vacancyType, final String author, final String create) {
        this.author = author;
        this.vacancyType = vacancyType;
        this.create = create;
    }

    public String getAuthor() {
        return author;
    }

    public String getVacancyType() {
        return vacancyType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return hash == vacancy.hash
                && Objects.equals(author, vacancy.author)
                && Objects.equals(vacancyType, vacancy.vacancyType)
                && Objects.equals(create, vacancy.create);
    }

    @Override
    public int hashCode() {
        hash = 31;
        hash = hash * 17 + vacancyType.hashCode()
                + hash * 17 + author.hashCode();
        return hash;

    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "author= '"
                + author + '\''
                + ", vacancyType = '"
                + vacancyType + '\''
                + ", create= "
                + create
                + '}';
    }
    public String getCreate() {
        return create;
    }
}
