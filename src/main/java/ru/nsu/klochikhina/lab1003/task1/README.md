# Первое задание

Стандартная задача Producer-Consumer (Производитель-Потребитель).
Создайте генерик класс Склад (Storage), у него есть методы положить товар и забрать товар (тип “товара” —
аргумент генерика). У склада есть максимальная вместимость, которая задается при конструировании и не
меняется. Если поток исполнения пытается положить товар на склад, а тот уже заполнен, поток засыпает, пока
на складе не появится место. Если поток пытается взять товар со склада, а тот пуст, поток засыпает, пока на
складе не появится товар.
Запросите числа N, P, C. Создайте экземпляр склада строк размера N. Создайте P потоков-производителей
(Producers), каждый из которых кладет на склад строку вида “p<номер производителя>-<номер товара>” со всё
возрастающим номером товара. Создайте C потоков-потребителей (Consumers), каждый из которых раз в
секунду берет со склада строку и печатает на консоль “c<номер потребителя> consumes <товар>”, после чего
ждет 50-100мс.