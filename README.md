# EcommerceConceptTestExcercise
## Демонстрация тестового задания

При запуске проекта нас встречает splash screen

[1.webm](https://user-images.githubusercontent.com/73552496/203527270-9a27de67-6630-4e53-8cdd-fdd78b7a0339.webm)

На стартовом экране можно выбрать категорию, Hot Sales прокручивается автоматически а снизу распологается Best Seller.

[ezgif-3-2e2ddf8b1b.webm](https://user-images.githubusercontent.com/73552496/203528016-3d278271-7386-4cf6-8a26-ff3694a7310c.webm)

по клику на view all открывается filter options

[ezgif-3.webm](https://user-images.githubusercontent.com/73552496/203529059-c8c840d7-5ab4-482f-b067-44a93b4b2636.webm)

по клику на товар открывается фрагмент с деталями

[ezgif-4.webm](https://user-images.githubusercontent.com/73552496/203529226-03a4121b-2adc-4d6c-9bf2-77843c582c12.webm)

в тапбаре отображается кол-во товаров в корзине. По тапу открывается фрагмент с корзиной

[ezgif-5.webm](https://user-images.githubusercontent.com/73552496/203529433-88e009b8-cf57-4480-bdd4-dea72ef40e44.webm)


### Techs

Для реализации проекта использовались следующие решения
- MVVM + LiveData в качестве архитектуры
- Retrofit для запросов на сервер
- Koin для инъекции зависимостей
- Coil для загрузки изображение в ImageView
- Кнопки с выбором элементов, например категории или выбор цвета/памяти сделаны в RecyclerView а сама логика выбора зашита в адаптер
- В качестве адаптера для товаров используется классический RecyclerView.Adapter, а для корзины используется AdapterDelegates
- Категорию Hot Sales решил реализовать через ViewPager2
- Для красивого тапбара используется библиотека chip-navigation-bar
- Для простой карусели используется библиотека whynotimagecarousel
- Проект разбил на три модуля app, domain, data.
