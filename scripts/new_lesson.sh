#!/bin/bash

PROJECT="$HOME/Project/Kotlin/Lesson"
TEMPLATE="$PROJECT/_template/Main.kt"

read -p "Введите номер нового урока: " NUMBER

if ! [[ "$NUMBER" =~ ^[0-9]+$ ]]; then
    echo "Ошибка: номер должен содержать только цифры."
    exit 1
fi

LESSON="$PROJECT/Lesson$NUMBER"

if [[ -d "$LESSON" ]]; then
    echo "Ошибка: такая папка уже существует."
    exit 1
fi

mkdir -p "$LESSON"

cp "$TEMPLATE" "$LESSON/Main.kt"

echo "Создан урок Lesson$NUMBER"

code --reuse-window "$LESSON/Main.kt"
