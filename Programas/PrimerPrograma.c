#include <stdio.h>

int main(void)
{
    printf("Hello World!\n");
    //HelloWorld!("print");

    int i;
    float x = 0.0, y = 0.0, z = 0.0, promedio;
    float arreglo[10];
    char letra = 'A';

    //Llenar arreglo
    for(i = 0; i < 10; i++)
    {
        printf("Ingrese el dato %d: ", i);
        scanf("%f", &arreglo[i]);
    }

    i = 0;
    
    //Calcular el promedio
    while(i < 10)
    {
        promedio += arreglo[i];
        i += 1;
    }
    promedio /= 10;
    
    printf("El promedio es: %f\n", promedio);


    //Comparar X y Y
    x = arreglo[0];
    y = arreglo[9];

    if(x > y)
    {
        printf("X es mayor que Y\n");
        z = x;
    }
    else if(y > x)
    {
        printf("Y es mayor que X\n");
        z = y;
    }
    else
    {
        printf("X y Y son iguales\n");
        z = -1;
    }

    printf("El resultado de Z es: %f\n", z);

    //Elevar Z al cuadrado
    z *= z;
    //z ^= 2;
    printf("Z ^ 2 = %f\n", z);
    
    //Uso de break y continue
    for(i = 9; i > 0; i--)
    {
        if(arreglo[i] >= arreglo[i-1])
        {
            printf("%d.- Continue\n", i);
            continue;
        }
        else
        {
            printf("%d.- Break\n", i);
            break;
        }
    }

    return 0;
}