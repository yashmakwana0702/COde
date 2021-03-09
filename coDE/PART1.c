#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define MAX_DELIVERIES 10
#define MAX_STOCK_ITEMS 50

struct StockRecord
{
    int sku;
    int deliveries[MAX_DELIVERIES];
    int numDeliveries;
    int numSold;
};

int main(void)
{
    struct StockRecord stock[MAX_STOCK_ITEMS] = {
        {748, {0}, 0, 0},
        {619, {0}, 0, 0},
        {821, {0}, 0, 0},
        {554, {0}, 0, 0}
    };
    int keepRunning = 1, sku, posn = 0, i, numStockItems = 4, quantity = 0, validAction = 0;
    int found = 0, total = 0, j, lastDelivery = 0;
    char action;

    while (keepRunning)
    {
        printf("Enter d (Delivery) or s (Sale) or x (eXit): ");
        scanf("%c%*c", &action);
        if (validAction = action == 's' || action == 'S' || action == 'd' || action == 'D')
        {
            printf("Enter the SKU: ");
            scanf("%d%*c", &sku);
            posn = -1;
            found = 0;
            for (i = 0; i < numStockItems && !found; i++)
            {
                if (stock[i].sku == sku)
                {
                    posn = i;
                    found = 1;
                }
            }
        }

        if (posn < 0 && validAction)
        {
            printf("SKU cannot be found\n");
        }
        else
        {
            if (validAction)
            {
                printf("Enter the quantity delivered or sold: ");
                scanf("%d%*c", &quantity);
            }

            switch (action)
            {
            case 'd':
            case 'D':
                lastDelivery = stock[posn].numDeliveries;//i change to posn
                stock[posn].deliveries[lastDelivery] += quantity;//= to +=
                stock[posn].numDeliveries++;
                break;
            case 's':
            case 'S':
                total = 0;
                for (j = 0; j < stock[posn].numDeliveries; j++)
                {
                    total += stock[posn].deliveries[j];
                }
                if (total >= (quantity + stock[posn].numSold))
                {
                    stock[posn].numSold += quantity;// +instead of -
                    stock[posn].deliveries[lastDelivery]-=quantity;  // new line
                }
                else
                {
                    printf("Error: cannot sell more than we have in stock\n");
                }
                break;
            case 'x':
            case 'X':
                keepRunning = 0;
                break;
            default:
                printf("Invalid action %c\n", action);
                break;
            }
        }
    }
    printf("%4s%6s%16s\n", "SKU", "Sales", "Remaining Stock");
    for (i = 0; i < numStockItems; i++)
    {
        total = 0;
        for (j = 0; j < stock[i].numDeliveries; j++)
        {
            total += stock[i].deliveries[j];
        }
        printf("%4d%6d%16d\n", stock[i].sku, stock[i].numSold, total);
    }

    return 0;
}

