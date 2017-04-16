package ru.chedmitriy.collections.modifiingTracker.objects;

/**
 *
 * Наследник Объекта Item, с возможностью внесения комментарвиев
 */
public class Comments extends Item {

    /**
     * Параметр - ответ при отсутствии комментариев
     * */
    private String comments = "there are no comments";

    /**.
        *возвращает комментарий
     * * */
    public String getComments() {
        return comments;
    }


    /**.
    * Конструктор объекта Comments
    * @param name  - имя объкта
    * @param description - описание
    * @param comments - комментарии
    * */
    public Comments(final String name, final String description, final String comments) {
        super(name, description);
        this.comments = comments;
    }
    /**.
    * Сеттер добавляет комментарии к объекту
     * @param comments - передаваемый параметр
    * */
    public void setComments(final String comments) {
        this.comments = comments;
    }
}
