public class ProductManager {

    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(ProductService product) {
        repo.add(product);
    }

    public ProductService[] searchBy(String text) {
        ProductService[] result = new ProductService[0];
        for (ProductService product: repo.findAll()) {
            if (matches(product, text)) {
                ProductService[] tmp = new ProductService[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(ProductService product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
