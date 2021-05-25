#!/bin/bash
COUNT=`head -1 file.txt | wc -w`
for (( i = 1; i <= $COUNT; i++ )); do
    awk -v arg=$i '{print $arg}' file.txt | xargs
done

#前10航
grep -n "" file.txt | grep -w '10' | cut -d: -f2
sed -n '10p' file.txt
awk '{if(NR==10){print $0}}' file.txt

