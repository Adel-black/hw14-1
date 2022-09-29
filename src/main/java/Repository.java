public class Repository {

    ProductService[] products = new ProductService[0];

    public void add(ProductService product) {
        ProductService[] tmp = new ProductService[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
    public ProductService[] findAll() {
        return products;
    }

    public void delete(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }

        ProductService[] tmp = new ProductService[products.length - 1];
        int indexTo = 0;
        for (ProductService product : products) {
            if (product.getId() != id) {
                tmp[indexTo] = product;
                indexTo++;
            }
        }
        products = tmp;
    }

    public ProductService findById(int id) {
        for (ProductService product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

