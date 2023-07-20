package cl.awakelab.ejercicioindividual16modulo5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual16modulo5.databinding.ItemBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()

    class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pais) {
            binding.textViewName.text = item.nombre
            binding.textViewPopulation.text = "Población: ${item.poblacion.toString()}"
            binding.imageViewFlag.load(item.imgUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        var item = paises[position]
        holder.bind(item)
    }

    fun setData(listaPaises: MutableList<Pais>) {
        this.paises = listaPaises
    }


}

